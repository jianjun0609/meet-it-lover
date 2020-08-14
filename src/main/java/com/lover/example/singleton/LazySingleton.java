package com.lover.example.singleton;

/**
 * 单例模式-懒汉模式
 * @author Jack
 * @date 2020/7/3 11:24
 */
public class LazySingleton {

    private static LazySingleton singleton;

    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized(LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    private LazySingleton() {
    }
}
