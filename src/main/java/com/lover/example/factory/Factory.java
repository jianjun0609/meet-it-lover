package com.lover.example.factory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class Factory {

    public Phone createPhone(String phoneName) {
        if ("apple".equals(phoneName)) {
            return new IPhone();
        } else if ("huawei".equals(phoneName)) {
            return new HuaWei();
        }
        return null;
    }
}
