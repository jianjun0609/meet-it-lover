package com.lover.controller;

import com.laiai.core.BaseController;
import com.laiai.core.Result;
import com.laiai.core.exception.BusinessException;
import com.lover.common.constant.ErrorCode;
import com.lover.service.UploadService;
import com.lover.swagger.UpdateSwagger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;

/**
 * @author Jack
 * @date 2020-06-03 11:33:04
 */
@RestController
@RequestMapping("/upload")
public class UploadController extends BaseController implements UpdateSwagger {
    @Resource
    private UploadService uploadService;

    @PostMapping("/uploadFile")
    @Override
    public Result uploadFile(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.YM_UPLOAD_FILE_ERROR,"上传文件不能为空");
        }
        Map<String,Object> map = uploadService.uploadFile(file);
        return success(map);
    }

    /**
     * 上传视频
     */
    @PostMapping("/video")
    @Override
    public Result uploadVideo(@RequestParam MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new BusinessException(ErrorCode.YM_UPLOAD_FILE_ERROR,"上传文件不能为空");
        }
        //判断文件是否是视频
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if(suffix.toUpperCase().equals(".MP4") || suffix.toUpperCase().equals(".MPEG") || suffix.toUpperCase().equals(".OGG")){
            Map<String,Object> map = uploadService.uploadVideo(file);
            return success(map);
        }else{
            throw new BusinessException(ErrorCode.YM_UPLOAD_VODIE_TYPE_ERROR,"该文件视频格式，不支持");
        }
    }
}
