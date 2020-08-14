package com.lover.example.builder;

import com.lover.example.factory.Factory;
import com.lover.example.factory.Phone;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        ComputerDirector computerDirector = new ComputerDirector();
        ComputerBuilder computerBuilder = new ComputerConcreteBuilder();
        Computer computer = computerDirector.constructComputer(computerBuilder);
        System.out.println(computer.getCpu());
        System.out.println(computer.getMemory());
        System.out.println(computer.getDisk());
    }
}
