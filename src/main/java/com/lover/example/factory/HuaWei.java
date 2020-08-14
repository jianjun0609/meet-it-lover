package com.lover.example.factory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class HuaWei implements Phone {
    @Override
    public String brand() {
        System.out.println("I`m HuaWei");
        return "I`m HuaWei";
    }
}
