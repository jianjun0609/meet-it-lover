package com.lover.example.builder;

/**
 * @author Jack
 * @date 2020/7/3 13:59
 */
public class ComputerConcreteBuilder implements ComputerBuilder {

    private Computer computer;

    public ComputerConcreteBuilder() {
        computer = new Computer();
    }

    @Override
    public void buildCpu() {
        System.out.println("build cpu...");
        computer.setCpu("8 core");
    }

    @Override
    public void buildMemory() {
        System.out.println("build memory...");
        computer.setMemory("16G");
    }

    @Override
    public void buildDisk() {
        System.out.println("build disk...");
        computer.setDisk("1TG");
    }

    @Override
    public Computer buildComputer() {
        return computer;
    }
}
