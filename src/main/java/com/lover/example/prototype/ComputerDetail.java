package com.lover.example.prototype;

import lombok.Data;

/**
 * @author Jack
 * @date 2020/7/3 14:23
 */
@Data
public class ComputerDetail implements Cloneable{

    private String cpu;
    private String memory;
    private Disk disk;

    public ComputerDetail(String cpu, String memory, Disk disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    @Override
    public ComputerDetail clone() { // 浅复制
        try {
            ComputerDetail computerDetail = (ComputerDetail)super.clone();
            computerDetail.disk = this.disk.clone();
            return computerDetail;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
