package com.lover.api;

import com.laiai.core.BaseController;
import com.laiai.core.Result;
import com.laiai.core.util.ParameterUtils;
import com.lover.model.ItUserInfo;
import com.lover.service.ItUserInfoService;
import com.lover.swagger.YmPassportSwagger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Jack
 * @date 2020-06-03 12:12:14
 */
@RestController
@RequestMapping("/api/passport")
public class YmPassportApi extends BaseController implements YmPassportSwagger {

    @Value("${jwt.token-header}")
    private String tokenHeader;
    @Resource
    private ItUserInfoService itUserInfoService;

    @Override
    @PostMapping("/login")
    public Result login(@RequestParam String accountName, @RequestParam String password) {
        Map<String, Object> dataMap = itUserInfoService.passwordLogin(accountName, password);
        return success(dataMap, "登录成功");
    }

    @Override
    @PostMapping("/register")
    public Result register(@RequestParam String accountName, @RequestParam String password, @RequestParam Byte sex)  {
        itUserInfoService.register(accountName, password, sex);
        return success();
    }

    @Override
    @PostMapping("/getUserInfo")
    public Result<ItUserInfo> getUserInfo() {
        Integer currentUserId = ParameterUtils.getCurrentUserId();
        ItUserInfo userInfo = itUserInfoService.findById(currentUserId.longValue());
        return success(userInfo);
    }

    @Override
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        itUserInfoService.logout(token);
        return success();
    }
}
