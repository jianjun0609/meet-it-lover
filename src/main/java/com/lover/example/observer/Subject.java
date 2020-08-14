package com.lover.example.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标类
 * @author Jack
 * @date 2020/7/21 10:50
 */
public abstract class Subject {

    protected List<Observer> observers = new ArrayList<>();

    // 增加观察者
    public void add(Observer observer) {
        observers.add(observer);
    }

    // 删除观察者
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObserver(String message); // 通知观察者的抽象方法
}
