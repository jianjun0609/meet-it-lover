package com.lover.example.adapter;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
        // 类适配器测试
        /*Targetable target = new Adapter();
        target.editTextFile();
        target.editWorldFile();*/

        // 对象适配器测试
        /*Targetable target = new ObjectAdapter(new Source());
        target.editTextFile();
        target.editWorldFile();*/

        // 接口适配器测试
        Sourceable source1 = new SourceSub1();
        Sourceable source2 = new SourceSub2();
        source1.editTextFile();
        source2.editWorldFile();
    }
}
