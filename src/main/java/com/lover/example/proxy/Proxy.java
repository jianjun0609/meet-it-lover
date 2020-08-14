package com.lover.example.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jack
 * @date 2020/7/6 11:08
 */
public class Proxy implements Company {

    private HR hr;

    public Proxy() {
        super();
        this.hr = new HR();
    }

    @Override
    public void findWorker(String title) {
        hr.findWorker(title);
        // 通过猎头找候选人
        String worker = getWorker(title);
        System.out.println("find a worker by proxy, worker name is :" + worker);
    }

    private String getWorker(String title) {
        Map<String, String> workerList = new HashMap<String, String>() {
            {
                put("Java", "张三");
                put("Python", "李四");
                put("Php", "王五");
            }
        };
        return workerList.get(title);
    }
}
