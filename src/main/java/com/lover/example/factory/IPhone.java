package com.lover.example.factory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class IPhone implements Phone {
    @Override
    public String brand() {
        System.out.println("I`m IPone");
        return "I`m IPone";
    }
}
