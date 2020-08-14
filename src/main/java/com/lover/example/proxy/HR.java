package com.lover.example.proxy;

/**
 * @author Jack
 * @date 2020/7/6 11:08
 */
public class HR implements Company {
    @Override
    public void findWorker(String title) {
        System.out.println("i need find a worker, title is:" + title);
    }
}
