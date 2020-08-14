package com.lover.example.Strategy;

/**
 * @author Jack
 * @date 2020/7/7 12:12
 */
public class TraveByAirStrategy implements TravelStrategy {
    @Override
    public void travelMode() {
        System.out.println("travel by air");
    }
}
