package com.lover.example.builder;

/**
 * @author Jack
 * @date 2020/7/3 13:56
 */
public interface ComputerBuilder {

    void buildCpu();

    void buildMemory();

    void buildDisk();

    Computer buildComputer();

}
