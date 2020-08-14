package com.lover.example.mediator;

/**
 * @author Jack
 * @date 2020/7/22 15:13
 */
public abstract class Colleague {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract boolean operation(String message); // 同事类的操作
}
