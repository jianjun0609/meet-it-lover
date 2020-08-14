package com.lover.example.visitor;

/**
 * @author Jack
 * @date 2020/7/22 14:13
 */
public interface Element {
    void accept(Visitor visitor);
}
