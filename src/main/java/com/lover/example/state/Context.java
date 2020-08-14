package com.lover.example.state;

/**
 * @author Jack
 * @date 2020/7/22 11:07
 */
public class Context {

    private AbstractState state;

    public Context(AbstractState state) {
        this.state = state;
    }

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        this.state = state;
    }

    public void action() {
        this.state.action(this);
    }
}
