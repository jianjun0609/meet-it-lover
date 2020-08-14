package com.lover.example.flyweight;

import lombok.Data;

/**
 * @author Jack
 * @date 2020/7/7 11:29
 */
@Data
public class Memory {

    private int size; // 内存大小，单位为MB
    private boolean isused; // 内存是否在被使用
    private String id; // 内存id

    public Memory(int size, boolean isused, String id) {
        this.size = size;
        this.isused = isused;
        this.id = id;
    }
}
