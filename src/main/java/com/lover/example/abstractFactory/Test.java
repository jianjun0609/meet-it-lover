package com.lover.example.abstractFactory;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory computerFactory = new ComputerFactory();
        Computer appleComputer = computerFactory.createComputer("apple");
        Computer huaweiComputer = computerFactory.createComputer("huawei");
        AbstractFactory phoneFactory = new PhoneFactory();
        Phone applePhone = phoneFactory.createPhone("apple");
        Phone huaweiPhone = phoneFactory.createPhone("huawei");
        applePhone.call();
        huaweiPhone.call();
        appleComputer.internet();
        huaweiComputer.internet();
    }
}
