package com.youyuan.liandizhifa;

import java.io.Serializable;

/**
 * @author zhangyu
 * @version 1.0
 * @description 哈希表的哈希冲突链表bean
 * @date 2018/11/7 13:31
 */
public class Node implements Serializable {
    private static final long serialVersionUID = -8548422413619398014L;
    /**
     * 哈希表链表中存储bean
     */
    private Info info;
    /**
     * 上一个节点
     */
    private Node beforeNode;
    /**
     * 下一个节点
     */
    private Node afterNode;

    public Node(Info info){
        this.info=info;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Node getBeforeNode() {
        return beforeNode;
    }

    public void setBeforeNode(Node beforeNode) {
        this.beforeNode = beforeNode;
    }

    public Node getAfterNode() {
        return afterNode;
    }

    public void setAfterNode(Node afterNode) {
        this.afterNode = afterNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "info=" + info +
                '}';
    }
}
