package com.lover.example.state;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {

        // 定义当前状态为工作状态
        Context context = new Context(new WorkState());
        context.action();
        // 切换当前状态为修改状态
        context.setState(new HolidayState());
        context.action();
    }

}
