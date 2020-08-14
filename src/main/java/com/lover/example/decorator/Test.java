package com.lover.example.decorator;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        Decorator decorator = new Decorator(new Source());
        decorator.createComputer();
    }

}
