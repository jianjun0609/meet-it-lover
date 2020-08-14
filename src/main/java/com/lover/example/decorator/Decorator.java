package com.lover.example.decorator;

/**
 * @author Jack
 * @date 2020/7/3 17:35
 */
public class Decorator implements Sourceable {

    private Source source;

    public Decorator(Source source) {
        this.source = source;
    }

    @Override
    public void createComputer() {
        this.source.createComputer();
        // 在创建完成电脑后给电脑装上系统
        System.out.println("make system.");
    }
}
