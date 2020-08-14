package com.lover.example.mediator;

/**
 * @author Jack
 * @date 2020/7/22 15:16
 */
public class ColleagueLandlord extends Colleague {
    @Override
    public boolean operation(String message) {
        System.out.println("landlord receive a message form mediator:" + message);
        return true;
    }
}
