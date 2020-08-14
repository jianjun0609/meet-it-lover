package com.lover.example.singleton;

/**
 * 单例模式-懒汉模式
 * @author Jack
 * @date 2020/7/3 11:24
 */
public class HungrySingleton {

    private static HungrySingleton singleton = new HungrySingleton();

    public static HungrySingleton getSingleton() {
        return singleton;
    }

    private HungrySingleton() {
    }
}
