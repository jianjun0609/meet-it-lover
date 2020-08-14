package com.lover.example.interpreter;

import java.util.HashMap;

/**
 * @author Jack
 * @date 2020/7/22 16:50
 */
public class Context {

    private HashMap map = new HashMap();

    public void assign(String key, String value) {
        // 在环境类中设值
    }

    public String get(String key) {
        // 获取存储在环境类中的值
        return "";
    }
}
