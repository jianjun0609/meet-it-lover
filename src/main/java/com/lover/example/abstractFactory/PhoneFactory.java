package com.lover.example.abstractFactory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class PhoneFactory implements AbstractFactory{

    @Override
    public Phone createPhone(String brand) {
        if ("apple".equals(brand)) {
            return new IPhone();
        } else if ("huawei".equals(brand)) {
            return new HuaWei();
        }
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        return null;
    }
}
