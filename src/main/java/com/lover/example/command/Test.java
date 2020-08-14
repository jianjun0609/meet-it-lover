package com.lover.example.command;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {

        // 定义命令的接收和执行者
        Receiver receiver = new Receiver();
        // 定义命令实现类
        Command cmd = new ConcreteCommand(receiver);
        // 定义命令调用者
        Invoker invoker = new Invoker(cmd);
        // 命令调用
        invoker.action("command1");
    }

}
