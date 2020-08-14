package com.lover.example.state;

/**
 * @author Jack
 * @date 2020/7/22 11:14
 */
public class WorkState extends AbstractState {
    @Override
    public void action(Context context) {
        System.out.println("state change to work state");
        System.out.println("work state action is meeting, design, coding...");
    }
}
