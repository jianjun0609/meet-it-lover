package com.lover.example.composite;

import com.alibaba.fastjson.JSONObject;

/**
 * @author Jack
 * @date 2020/7/3 11:06
 */
public class Test {

    public static void main(String[] args) {
       TreeNode nodeA = new TreeNode("A");
       TreeNode nodeB = new TreeNode("B");
       nodeA.add(nodeB);
        System.out.println(JSONObject.toJSONString(nodeA));
    }

}
