package com.lover.example.prototype;

import lombok.Data;

/**
 * @author Jack
 * @date 2020/7/3 14:23
 */
@Data
public class Computer implements Cloneable{

    private String cpu;
    private String memory;
    private String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    public Computer clone() { // 浅复制
        try {
            return (Computer)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
