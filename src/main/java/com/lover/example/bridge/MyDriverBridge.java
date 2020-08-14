package com.lover.example.bridge;

/**
 * @author Jack
 * @date 2020/7/7 10:49
 */
public class MyDriverBridge extends DriverManagerBridge{

    public void execute() {
        getDriver().executeSQL();
    }
}
