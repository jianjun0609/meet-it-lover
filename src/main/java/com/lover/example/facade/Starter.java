package com.lover.example.facade;

/**
 * @author Jack
 * @date 2020/7/7 10:28
 */
public class Starter {

    private Dashboard dashboard;
    private Engine engine;
    private SelfCheck selfCheck;

    public Starter() {
        this.dashboard = new Dashboard();
        this.engine = new Engine();
        this.selfCheck = new SelfCheck();
    }

    public void startup() {
        System.out.println("car begine startup");
        engine.startup();
        dashboard.startup();
        selfCheck.startupCheck();
        System.out.println("car startup finished");
    }

    public void shutdown() {
        System.out.println("car begine shutdown");
        selfCheck.shutdowncheck();
        engine.shutdown();
        dashboard.shutdown();
        System.out.println("car shutdown finished");
    }
}
