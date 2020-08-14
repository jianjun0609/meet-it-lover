package com.lover.example.composite;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author Jack
 * @date 2020/7/7 10:59
 */
public class TreeNode {

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    // 添加子节点
    public void add(TreeNode node) {
        this.children.add(node);
    }

    // 删除子节点
    public void remode(TreeNode node) {
        this.children.remove(node);
    }

    // 获取子节点
    public Enumeration<TreeNode> getChildren() {
        return this.children.elements();
    }
}
