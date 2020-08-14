package com.lover.example.bridge;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        DriverManagerBridge driverManagerBridge = new MyDriverBridge();
        // 设置MySQL驱动
        driverManagerBridge.setDriver(new MysqlDriver());
        driverManagerBridge.execute();
        // 切换到Oracle驱动
        driverManagerBridge.setDriver(new OracleDriver());
        driverManagerBridge.execute();
    }

}
