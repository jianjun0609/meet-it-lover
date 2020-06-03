package com.lover.service;

import com.lover.model.ItUserInfo;
import com.laiai.core.abstractbean.Service;

import java.util.Map;

/**
 * @description:
 * @author Jack
 * @date 2020-06-03 15:56:23
 */
public interface ItUserInfoService extends Service<ItUserInfo> {

    void register(String accountName, String password, Byte sex);

    Map<String, Object> passwordLogin(String accountName, String password);

    void logout(String token);
}
