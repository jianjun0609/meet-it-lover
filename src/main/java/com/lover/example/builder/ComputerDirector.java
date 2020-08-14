package com.lover.example.builder;

/**
 * @author Jack
 * @date 2020/7/3 14:02
 */
public class ComputerDirector {

    public Computer constructComputer(ComputerBuilder computerBuilder) {
        computerBuilder.buildCpu();
        computerBuilder.buildMemory();
        computerBuilder.buildDisk();
        return computerBuilder.buildComputer();
    }
}
