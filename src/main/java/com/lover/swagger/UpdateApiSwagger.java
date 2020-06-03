package com.lover.swagger;

import com.laiai.core.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Api(tags = "客户端-文件上传")
public interface UpdateApiSwagger {

     @ApiOperation(value="文件上传", notes="视频上传限制在50M以内")
     Result uploadFile(@RequestParam MultipartFile file) throws IOException;

     @ApiOperation(value="视频上传", notes="视频上传限制在50M以内")
     Result uploadVideo(@RequestParam MultipartFile file) throws IOException;
}
