package com.lover.example.mediator;

/**
 * @author Jack
 * @date 2020/7/22 15:32
 */
public abstract class Mediator {

    protected Colleague colleagueTenant;
    protected Colleague colleagueLandlord;

    public Mediator(Colleague colleagueTenant, Colleague colleagueLandlord) {
        this.colleagueTenant = colleagueTenant;
        this.colleagueLandlord = colleagueLandlord;
    }

    public abstract boolean notifyColleagueTenant(String message);

    public abstract boolean notifyColleagueLandlord(String message);
}
