package com.lover.example.observer;

/**
 * @author Jack
 * @date 2020/7/21 14:51
 */
public class ConcreteObserver implements Observer {

    @Override
    public void dataChange(String message) {
        System.out.println("recive message:" + message);
    }

}
