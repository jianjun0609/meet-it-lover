package com.lover.example.adapter;

/**
 * @author Jack
 * @date 2020/7/3 15:27
 */
public class Adapter extends Source implements Targetable {
    @Override
    public void editWorldFile() {
        System.out.println("a word file editing");
    }
}
