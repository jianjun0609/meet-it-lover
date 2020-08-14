package com.lover.example.singleton;

/**
 * 单例模式-静态内部类 (因为静态内部类在JVM中是唯一的，这就很好保证了单例对象的唯一性)
 * @author Jack
 * @date 2020/7/3 11:24
 */
public class Singleton {

    private static Singleton singleton;

    public static final Singleton getSingleton() {
        return SingletonHolder.SINGLETON;
    }

    private Singleton() {
    }

    public static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();
    }
}
