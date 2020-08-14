package com.lover.example.adapter;

/**
 * @author Jack
 * @date 2020/7/3 15:35
 */
public class ObjectAdapter implements Targetable{

    private Source source;

    public ObjectAdapter(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void editTextFile() {
        this.source.editTextFile();
    }

    @Override
    public void editWorldFile() {
        System.out.println("a word file editing");
    }
}
