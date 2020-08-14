package com.lover.example.facade;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        Starter starter = new Starter();
        starter.startup();
        System.out.println("----------------------------");
        starter.shutdown();
    }

}
