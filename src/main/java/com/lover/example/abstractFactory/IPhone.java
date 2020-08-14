package com.lover.example.abstractFactory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class IPhone implements Phone {
    @Override
    public String call() {
        System.out.println("I`m apple phone");
        return "I`m apple phone";
    }
}
