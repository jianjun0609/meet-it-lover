package com.lover.example.template;

/**
 * @author Jack
 * @date 2020/7/7 15:17
 */
public abstract class AbstractTemplate {

    public void templateMethod() { // 模板方法，用于核心流程和算法的定义
        checkNumber();
        queueUp();
        handleBusiness();
        serviceEvaluation();
    }

    // 抽号
    public void checkNumber() {
        System.out.println("checkNumber......");
    }

    // 排队
    public void queueUp() {
        System.out.println("queue up.....");
    }

    // 办理业务
    public abstract void handleBusiness();

    // 服务评价
    public void serviceEvaluation() {
        System.out.println("business finished, servic evaluation....");
    }




}
