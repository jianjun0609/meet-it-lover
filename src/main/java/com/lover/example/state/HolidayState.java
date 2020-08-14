package com.lover.example.state;

/**
 * @author Jack
 * @date 2020/7/22 11:12
 */
public class HolidayState extends AbstractState {
    @Override
    public void action(Context context) {
        System.out.println("state change to holiday state");
        System.out.println("holiday state actions is travel, shopping, watch television...");
    }
}
