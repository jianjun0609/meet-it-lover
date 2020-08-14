package com.lover.example.singleton;

/**
 * 单例模式-双重锁校验（volatile关键字保证对象初始化时的唯一性）
 * @author Jack
 * @date 2020/7/3 11:24
 */
public class Lock2Singleton {

    // 保证可见性，禁止指令重排序优化 保证其他线程不会访问到一个未初始化的对象
    // 不加volatile关键字的风险 new Lock2Singleton() 不是一个原子性操作  分为3步 1：分配内存 2：对象初始化 3：变量赋值
    // 多线程情况下可能会出现指令重排 1 3 2    A线程走到变量赋值后 B线程进来判断不为null返回 但是这个对象可能还没有初始化
    // 还有另外一种方案 方法内部使用局部变量 首先将实例赋值给局部变量 然后在进行判断 ，最后内容写到局部变量 ，然后再将局部变量赋值给实例变量
    private volatile static Lock2Singleton singleton;

    public static Lock2Singleton getSingleton() {
        if (singleton == null) {
            synchronized(Lock2Singleton.class) {
                if (singleton == null) {
                    singleton = new Lock2Singleton();
                }
            }
        }

        return singleton;
    }

    private Lock2Singleton() {
    }
}
