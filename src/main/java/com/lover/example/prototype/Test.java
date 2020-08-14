package com.lover.example.prototype;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        // 浅复制
        Computer computer = new Computer("8core", "16G", "1TB");
        System.out.println("before simple clone:" + computer.toString());
        Computer computerClone = computer.clone();
        System.out.println("after simple clone:" + computerClone.toString());

        // 深复制
        Disk disk = new Disk("208G", "2TB");
        ComputerDetail computerDetail = new ComputerDetail("12core", "64G", disk);
        System.out.println("before deep clone:" + computerDetail.toString());
        ComputerDetail computerDetailClone = computerDetail.clone();
        System.out.println("after deep clone:" + computerDetailClone.toString());
    }
}
