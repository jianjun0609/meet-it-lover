package com.lover.intercept;

import com.alibaba.fastjson.JSON;
import com.laiai.core.Result;
import com.laiai.core.exception.BusinessException;
import com.laiai.core.util.ParameterUtils;
import com.lover.common.enums.UserErrorCode;
import com.lover.model.ItUserInfo;
import com.lover.service.ItUserInfoService;
import com.laiai.platform.util.StrKit;
import com.laiai.ys.common.constant.ClientEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.mapper.util.StringUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * desc: 拦截器
 *
 * @author llt
 * @date 2020年03月24日 11:26:06
 */
@Component
public class AdminAuthInterceptor extends HandlerInterceptorAdapter {

    private final Logger logger = LoggerFactory.getLogger(AdminAuthInterceptor.class);

    public static final String REQUEST_ID_KEY = "X-RequestId";

    @Value("${header-client}")
    private String headerClient;

    @Value("${header-token}")
    private String headerToken;

    @Value("${header-application_code}")
    private String headerApplicationCode;

    @Value("${ignore.startWith}")
    private String gateIgnoreStartWith;

    @Value("${web.ignore.startWith}")
    private String webIgnoreStartWith;

    @Resource
    private ItUserInfoService itUserInfoService;



    @Autowired
    WebApplicationContext webApplicationContext;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestUri = request.getRequestURI();
        request.setAttribute(REQUEST_ID_KEY, UUID.randomUUID());
        String method = request.getMethod();
        String client = request.getHeader(headerClient);
        String channel = request.getHeader("channel");
        String token = request.getHeader(headerToken);
        //OPTIONS全部放行
        if ("OPTIONS".equals(method)) {
            return true;
        }
        //接口是否放行
        if (this.isReleaseUrl(requestUri, gateIgnoreStartWith)) {
            return true;
        }
        //参数判断client
        if (StringUtil.isEmpty(client)) {
            throw new BusinessException(UserErrorCode.PARAMETER_CLIENT_ERROR.getCode(), UserErrorCode.PARAMETER_CLIENT_ERROR.getMsg());
        }
        //校验
        if (ClientEnum.ADMIN.getCode().equals(client)) {
            //平台端
            //SysAdminDTO adminInfo = null;
            //填充管理员信息到请求头
            //this.setAdminContext(request, adminInfo, token);
            return true;
        } else if (client.equals(ClientEnum.APP.getCode())) {
            //app拦截
            return this.checkToken(token, request, response, channel);
        } else if (client.equals(ClientEnum.WEB.getCode())) {
            if (this.isReleaseUrl(requestUri, webIgnoreStartWith)) {
                return true;
            }
            //web拦截
            return this.checkToken(token, request, response, channel);
        }
        responseResult(request, response, UserErrorCode.CLIENT_IS_NULL.getCode(), UserErrorCode.CLIENT_IS_NULL.getMsg());
        return false;
    }

    /**
     * desc:解密token
     *
     * @param token
     * @param request
     * @param response
     * @author llt
     * @date 2020年04月01日 14:24:16
     */
    private Boolean checkToken(String token, HttpServletRequest request, HttpServletResponse response, String channel) {
        ItUserInfo loginUser = getWebLoginUserObject(token, channel);
        if (loginUser == null) {
            responseResult(request, response, "4004", "您的账号已登出，请重新登录");
            return false;
        } else {
            setContext(request, loginUser, token);
            return true;
        }
    }


    /**
     * 根据accessToken 获取loginUser
     * 非管理后台使用  web app 使用
     * @param accessToken
     * @return
     */
    private ItUserInfo getWebLoginUserObject(String accessToken, String channel) {
        if (StrKit.isBlank(accessToken)) {
            return null;
        }
        ItUserInfo userInfo = itUserInfoService.findBy("accessToken", accessToken);
        return userInfo;
    }

    /**
     * desc:是否放行
     *
     * @param requestUri 请求地址
     * @param ignoreUrl     忽略的请求地址
     * @author llt
     * @date 2020年03月24日 14:11:19
     */
    private boolean isReleaseUrl(String requestUri, String ignoreUrl) {
        //全局校验：无论什么客户端都放行
        String[] arrUrl = ignoreUrl.split(",");
        if (arrUrl.length > 0) {
            for (String url : arrUrl) {
                if (requestUri.startsWith(url)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 设置用户信息context
     *
     * @param request  请求头
     * @param userInfo userInfo
     * @param token    令牌
     */
    private void setContext(HttpServletRequest request, ItUserInfo userInfo, String token) {
        request.setAttribute(headerToken, token);
        request.setAttribute("userId", userInfo.getId());
        request.setAttribute("phoneMobile", userInfo.getPhoneMobile());
        request.setAttribute("accountName", userInfo.getAccountName());
        request.setAttribute("nickName", userInfo.getNickName());
        ParameterUtils.setCurrentUserName(userInfo.getNickName());
    }

    /**
     * 响应体封装
     *
     * @param response 响应体
     * @param code     错误码
     * @param msg      错误信息
     */
    private void responseResult(HttpServletRequest request, HttpServletResponse response, String code, String msg) {
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type,Accept,token,X-Requested-With");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            Result result = new Result();
            result.setCode(code);
            result.setMsg(msg);
            result.setSuccess(false);
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }

}
