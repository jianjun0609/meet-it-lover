package com.lover.example.Strategy;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        Context context = new Context();
        TravelStrategy travelByAirStrategy = new TraveByAirStrategy();
        // 设置出行策略为飞机
        context.setTravelStrategy(travelByAirStrategy);
        context.travelMode();

        System.out.println("change TravelStrategt t0 travelByCarStrategy.....");

        // 设置出行策略为开车自驾
        TravelStrategy travelByCarStrategy = new TraveByCarStrategy();
        context.setTravelStrategy(travelByCarStrategy);
        context.travelMode();
    }

}
