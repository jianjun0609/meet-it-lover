package com.lover.example.factory;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        Factory factory = new Factory();
        Phone apple = factory.createPhone("apple");
        Phone huawei = factory.createPhone("huawei");
        apple.brand();
        huawei.brand();
    }
}
