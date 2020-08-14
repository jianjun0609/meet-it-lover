package com.lover.example.decorator;

/**
 * @author Jack
 * @date 2020/7/3 17:35
 */
public class Source implements Sourceable {
    @Override
    public void createComputer() {
        System.out.println("create computer by source");
    }
}
