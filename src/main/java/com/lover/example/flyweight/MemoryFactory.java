package com.lover.example.flyweight;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Jack
 * @date 2020/7/7 11:31
 */
public class MemoryFactory {
    //内存对象列表
    private static List<Memory> memoryList = new ArrayList<>();
    public static Memory getMemory(int size) {
        Memory memory = null;
        for (int i = 0; i < memoryList.size(); i++) {
            memory = memoryList.get(i);
            if (memory.getSize() == size && memory.isIsused() == false) {
                memory.setIsused(true);
                memoryList.set(i, memory);
                System.out.println("get memory form memoryList:" + JSONObject.toJSONString(memory));
                break;
            }
        }
        if (memory == null) {
            memory = new Memory(32, false, UUID.randomUUID().toString());
            System.out.println("create a new memory form system and add to memoryList:" + JSONObject.toJSONString(memory));
            memoryList.add(memory);
        }
        return memory;
    }

    // 释放内存
    public static void releaseMemoty(String id) {
        for (int i = 0; i < memoryList.size(); i++) {
            Memory memory = memoryList.get(i);
            if (memory.getId().equals(id)) {
                memory.setIsused(false);
                memoryList.set(i, memory);
                System.out.println("release memory:" + id);
                break;
            }
        }
    }
}
