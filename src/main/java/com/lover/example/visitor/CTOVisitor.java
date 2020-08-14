package com.lover.example.visitor;

import com.alibaba.fastjson.JSON;

import java.util.Date;

/**
 * @author Jack
 * @date 2020/7/22 14:12
 */
public class CTOVisitor implements Visitor {
    @Override
    public void visit(ProjectElement element) {
        System.out.println("CTO Visitor Element");
        element.signature("CTO", new Date());
        System.out.println(JSON.toJSON(element));
    }
}
