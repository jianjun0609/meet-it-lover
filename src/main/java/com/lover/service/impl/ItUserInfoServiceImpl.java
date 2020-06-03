package com.lover.service.impl;

import com.laiai.core.exception.BusinessException;
import com.lover.common.constant.ErrorCode;
import com.lover.mapper.ItUserInfoMapper;
import com.lover.model.ItUserInfo;
import com.lover.service.ItUserInfoService;
import com.laiai.core.abstractbean.AbstractService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description:
 * @author Jack
 * @date 2020-06-03 15:56:23
 */
@Service
@Transactional
public class ItUserInfoServiceImpl extends AbstractService<ItUserInfo> implements ItUserInfoService {

    @Resource
    private ItUserInfoMapper itUserInfoMapper;

    @Override
    public void register(String accountName, String password, Byte sex) {
        int length = accountName.length();
        if (length > 18 || length < 5) {
            throw new BusinessException("", "账号要大于5小号18位");
        }
        synchronized (accountName) {
            ItUserInfo userInfo = findBy("accountName", accountName);
            if (userInfo != null) {
                throw new BusinessException("", "该账号已经注册过");
            }
            userInfo = new ItUserInfo();
            userInfo.setAccountName(accountName);
            userInfo.setPassword(password);
            userInfo.setSex(sex);
            save(userInfo);
        }
    }

    @Override
    public Map<String, Object> passwordLogin(String accountName, String password) {
        accountName = accountName.trim();
        ItUserInfo param = new ItUserInfo();
        param.setAccountName(accountName);
        ItUserInfo userInfo = findModel(param);
        if (userInfo == null) {
            throw new BusinessException(ErrorCode.USER_INFO_ERROR, "用户名不存在");
        }
        if(userInfo.getEnabled() == 0){
            throw new BusinessException(ErrorCode.USER_INFO_ERROR, "该账户状态异常");
        }
        if(!userInfo.getPassword().equalsIgnoreCase(password)){
            throw new BusinessException(ErrorCode.USER_INFO_ERROR, "密码错误");
        }
        userInfo.setLastLogin(new Date());
        userInfo.setLoginTimes(userInfo.getLoginTimes() + 1);
        Long userId = userInfo.getId();
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("accountName", userInfo.getAccountName());
        dataMap.put("nickName", userInfo.getNickName());
        dataMap.put("userId", userId);
        UUID uuid = UUID.randomUUID();
        String accessToken = uuid.toString() + "-" + userId;
        userInfo.setAccessToken(accessToken);
        update(userInfo);
        dataMap.put("accessToken", accessToken);
        return dataMap;
    }

    @Override
    public void logout(String token) {
        if (StringUtils.isBlank(token)) {
            return;
        }
        ItUserInfo userInfo = findBy("accessToken", token);
        if (userInfo == null) {
            return;
        }
        userInfo.setAccessToken("");
        update(userInfo);
    }
}
