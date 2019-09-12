package com.youyuan.list;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 链表节点实体
 * @date 2018/11/1 17:39
 */
public class Node implements Serializable {

    private static final long serialVersionUID = -5571029279526856050L;
    /**
     * 数据
     */
    private long data;
    /**
     * 下一个node
     */
    private Node next;

    public Node() {

    }
    /**
     * 初始化数据的构造方法
     * @param value 数据
     */
    public Node(long value) {
        this.data = value;
    }

    /**
     * 打印当前节点数据
     */
    public void display(){
        System.out.print(data+" ");
    }
    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
