package com.youyuan.tree;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 二叉树bean
 * @date 2018/11/5 19:54
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 289478258189223375L;
    /**
     * 数据项
     */
    private long data;
    /**
     * 数据项
     */
    private String sData;
    /**
     * 左节点
     */
    private Node leftChild;
    /**
     * 右节点
     */
    private Node rightChild;

    public Node(long data, String sData) {
        this.data = data;
        this.sData = sData;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public String getsData() {
        return sData;
    }

    public void setsData(String sData) {
        this.sData = sData;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", sData='" + sData + '\'' +
                '}';
    }
}
