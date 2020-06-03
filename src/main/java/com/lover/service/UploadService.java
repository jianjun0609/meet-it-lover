package com.lover.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;


/**
 * Created by CodeGenerator on 2018-07-15 11:33:04.
 */
public interface UploadService {

    Map<String, Object> uploadVideo(MultipartFile file) throws IOException;

    Map<String, Object> uploadFile(MultipartFile file) throws IOException;
}
