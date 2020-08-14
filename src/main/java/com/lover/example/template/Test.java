package com.lover.example.template;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        // 办理取钱流程
        AbstractTemplate template1 = new TakeMoney();
        template1.templateMethod();

        // 办理存储流程
        AbstractTemplate template2 = new SaveMoney();
        template2.templateMethod();
    }

}
