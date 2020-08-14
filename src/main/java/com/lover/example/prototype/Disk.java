package com.lover.example.prototype;

import lombok.Data;

/**
 * @author Jack
 * @date 2020/7/3 14:23
 */
@Data
public class Disk implements Cloneable{

    private String ssd;
    private String hhd;

    public Disk(String ssd, String hhd) {
        this.ssd = ssd;
        this.hhd = hhd;
    }

    @Override
    public Disk clone() { // 浅复制
        try {
            return (Disk)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
