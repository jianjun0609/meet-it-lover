package com.lover.example.flyweight;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {

        // 首次获取内存，将创建一个内存
        Memory memory = MemoryFactory.getMemory(32);

        // 在使用后释放内存
        MemoryFactory.releaseMemoty(memory.getId());

        // 重新获取内存
        MemoryFactory.getMemory(32);
    }

}
