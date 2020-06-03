package com.lover.swagger;

import com.laiai.core.Result;
import com.lover.model.ItUserInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Jack
 * @date 2020/6/3 19:01
 */
public interface YmPassportSwagger {

    @ApiOperation(value="登录", notes="登录")
    Result login(@RequestParam String accountName, @RequestParam String password);

    @ApiOperation(value="注册", notes="注册")
    Result register(@RequestParam String accountName, @RequestParam String password, @RequestParam Byte sex);

    @ApiOperation(value="获取用户信息", notes="获取用户信息")
    Result<ItUserInfo> getUserInfo();

    @ApiOperation(value="退出登录", notes="退出登录")
    Result logout(HttpServletRequest request);
}
