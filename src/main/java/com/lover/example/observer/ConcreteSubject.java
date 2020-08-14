package com.lover.example.observer;

/**
 * @author Jack
 * @date 2020/7/21 14:46
 */
public class ConcreteSubject extends Subject{

    @Override
    public void notifyObserver(String message) {
        for (Object obs : observers) {
            System.out.println("notify observer " + message + " change ...");
            ((Observer)obs).dataChange(message);
        }
    }
}
