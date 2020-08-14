package com.lover.example.abstractFactory;

/**
 * @author Jack
 * @date 2020/7/3 10:36
 */
public interface AbstractFactory {

    Phone createPhone(String brand);

    Computer createComputer(String brand);
}
