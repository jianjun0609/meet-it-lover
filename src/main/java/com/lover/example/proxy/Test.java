package com.lover.example.proxy;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        Company company = new Proxy();
        company.findWorker("Java");
    }
}
