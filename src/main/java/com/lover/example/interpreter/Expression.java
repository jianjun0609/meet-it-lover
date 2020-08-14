package com.lover.example.interpreter;

/**
 * @author Jack
 * @date 2020/7/22 16:46
 */
public interface Expression {

    public void interpret(Context ctx); // 解释方法
}
