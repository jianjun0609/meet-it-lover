package com.lover.example.bridge;

/**
 * @author Jack
 * @date 2020/7/7 10:46
 */
public class OracleDriver implements Driver {
    @Override
    public void executeSQL() {
        System.out.println("execute sql by oracle driver");
    }
}
