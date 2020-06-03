package com.lover.service.impl;

import com.aliyun.oss.OSSClient;
import com.laiai.core.exception.BusinessException;
import com.lover.common.constant.ErrorCode;
import com.lover.service.UploadService;
import com.lover.utils.DateUtil;
import com.lover.utils.Multfile2FileUtils;
import com.lover.utils.VideoUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class UploadServiceImpl implements UploadService {

    //视频存放文件夹
    public static final String VIDEO_FOLDER_NAME = "videos";
    //文件存放文件夹
    public static final String FILE_FOLDER_NAME = "file";

    @Value("${upload.endpoint}")
    private String endpoint;
    @Value("${upload.accessKeyId}")
    private String accessKeyId;
    @Value("${upload.accessKeySecret}")
    private String accessKeySecret;
    @Value("${upload.baseFolder}")
    private String baseFolder;
    @Value("${upload.bucketName}")
    private String bucketName;
    @Value("${upload.callBackUrl}")
    private String callBackUrl;

    /**
     * 视频上传
     * @param file 视频文件
     * @return 视频地址，大小，长度map
     */
    @Override
    public Map<String, Object> uploadVideo(MultipartFile file) throws IOException {
        //转换为IO的file
        File tempFile = Multfile2FileUtils.MultipartFileToFile(file);
        BigDecimal videoSize = VideoUtil.ReadVideoSize(tempFile);
        //视频大小在50M以内
        if(videoSize.compareTo(new BigDecimal(50)) >0 ){
            throw new BusinessException(ErrorCode.YM_UPLOAD_VODIE_LITMIT_ERROR,"该视频文件大于50M");
        }
        Long videoTime = VideoUtil.ReadVideoTime(tempFile);
        //删除临时文件
        String videoPath = upload(tempFile, VIDEO_FOLDER_NAME);
        Multfile2FileUtils.deleteFile(tempFile);
        Map<String, Object> map = new HashMap<>();
        map.put("videoPath", videoPath);
        map.put("videoTime", videoTime+"s");
        map.put("videoSize", videoSize+"MB");
        return map;
    }

    @Override
    public Map<String, Object> uploadFile(MultipartFile file) throws IOException {
        //转换为IO的file
        File tempFile = Multfile2FileUtils.MultipartFileToFile(file);
        String path = upload(tempFile, FILE_FOLDER_NAME);
        Multfile2FileUtils.deleteFile(tempFile);
        Map<String, Object> map = new HashMap<>();
        map.put("path", path);
        return map;
    }


    /**
     * 文件上传方法
     * @param file  文件file
     * @param folderPath  存放文件夹
     * @return     阿里云文件存放路径
     */
    private String upload(File file, String folderPath) {
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        String folder = this.getFilePath(file.getName(),folderPath);
        if (file.length() > 0) {
            try {
                ossClient.putObject(bucketName, folder, file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ossClient.shutdown();
        return callBackUrl + "/" + folder;
    }

    /**
     * 生成文件上传地址
     * @param sourceFileName 文件名称
     * @param folderName     存放文件夹名称
     * @return               存放相对路径
     */
    private String getFilePath(String sourceFileName,String folderName) {
        String thisBaseFolder = baseFolder + "/" + folderName;
        Date nowDate = new Date();
        String fileFolder = thisBaseFolder + "/" + DateUtil.format("yyyy", nowDate) + "/"
                + DateUtil.format("MM", nowDate) + DateUtil.format("dd", nowDate) + "/";
        String fileName = DateUtil.format("yyyyMMddhhmmssSSSS", nowDate) + "."
                + StringUtils.substringAfterLast(sourceFileName, ".");
        return fileFolder + fileName;
    }

}