package com.lover.example.memento;

/**
 * @author Jack
 * @date 2020/7/21 17:07
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
