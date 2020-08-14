package com.lover.example.abstractFactory;

/**
 * @author Jack
 * @date 2020/7/3 10:37
 */
public class ComputerFactory implements AbstractFactory{

    @Override
    public Phone createPhone(String brand) {
        return null;
    }

    @Override
    public Computer createComputer(String brand) {
        if ("apple".equals(brand)) {
            return new ComputerApple();
        } else if ("huawei".equals(brand)) {
            return new ComputerHuawei();
        }
        return null;
    }
}
