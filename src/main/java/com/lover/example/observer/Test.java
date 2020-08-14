package com.lover.example.observer;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        Observer obs = new ConcreteObserver();
        subject.add(obs);
        subject.notifyObserver("fuck !");
    }

}
