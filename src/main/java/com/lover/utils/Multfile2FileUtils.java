package com.lover.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * multfile 转换成  File 工具类
 * @author zengyou
 * @create 2018-07-12 19:46
 **/

public class Multfile2FileUtils {

    public static File MultipartFileToFile(MultipartFile multfile) throws IOException{
        // 获取文件名
        String fileName = multfile.getOriginalFilename();
        // 获取文件后缀
        String prefix=fileName.substring(fileName.lastIndexOf("."));
        // 用时间戳作为文件名，防止生成的临时文件重复
        File excelFile = File.createTempFile(CommonUtil.generateOrderNo(), prefix);
        excelFile.delete();
        // MultipartFile to File
        multfile.transferTo(excelFile);
        return excelFile;
    }

    //程序结束时，删除临时文件
    /**
     * 删除临时文件
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (file.exists()) {
            file.delete();
        }
    }
}
