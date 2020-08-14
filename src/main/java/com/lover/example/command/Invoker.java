package com.lover.example.command;

/**
 * @author Jack
 * @date 2020/7/21 16:18
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void action(String commandMessage) {
        command.exe(commandMessage);
    }
}
