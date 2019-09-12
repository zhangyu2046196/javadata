package com.youyuan.list;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 双向链表bean
 * @date 2018/11/2 11:21
 */
public class DoubleNode implements Serializable {
    private static final long serialVersionUID = -1699198497297270197L;
    /**
     * 数据
     */
    private long date;
    /**
     * 上一个节点
     */
    private DoubleNode before;
    /**
     * 下一个节点
     */
    private DoubleNode after;

    /**
     * 参数构造方法
     * @param value 参数值
     */
    public DoubleNode(long value){
        this.date=value;
    }

    /**
     * 显示
     */
    public void display(){
        System.out.print(this.date+" ");
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public DoubleNode getBefore() {
        return before;
    }

    public void setBefore(DoubleNode before) {
        this.before = before;
    }

    public DoubleNode getAfter() {
        return after;
    }

    public void setAfter(DoubleNode after) {
        this.after = after;
    }
}
