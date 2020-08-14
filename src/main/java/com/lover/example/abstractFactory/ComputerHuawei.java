package com.lover.example.abstractFactory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class ComputerHuawei implements Computer {
    @Override
    public String internet() {
        System.out.println("I`m huawei Computer");
        return "I`m huawei Computer";
    }
}
