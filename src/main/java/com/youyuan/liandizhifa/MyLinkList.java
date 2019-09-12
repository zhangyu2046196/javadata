package com.youyuan.liandizhifa;

/**
 * @author zhangyu
 * @version 1.0
 * @description 双向链表接口
 * @date 2018/11/7 13:38
 */
public class MyLinkList {
    /**
     * 链表第一个节点
     */
    private Node first;
    /**
     * 链表最后一个节点
     */
    private Node last;

    /**
     * 从列表前端插入
     * @param node 节点
     */
    public void insertFirst(Node node){
        if (node!=null){
            if (first==null){
                first=node;
                last=node;
            }else {
                node.setAfterNode(first);
                first.setBeforeNode(node);
                first=node;
            }
        }
    }

    /**
     * 从列表尾部插入
     * @param node 节点
     */
    public void insertLast(Node node){
        if (node!=null){
            if (last==null){
                first=node;
                last=node;
            }else {
                last.setAfterNode(node);
                node.setBeforeNode(last);
                last=node;
            }
        }
    }

    /**
     * 根据关键字查询元素
     * @param key 关键字
     * @return 哈希表bean
     */
    public Info findByKey(String key){
        if (key!=null && !"".equals(key)){
            //当前元素
            Node current=first;
            while (current!=null && !key.equals(current.getInfo().geteName())){
                current=current.getAfterNode();
            }
            if (current!=null){
                return current.getInfo();
            }
        }
        return null;
    }

    /**
     * 删除
     * @param key 关键字
     * @return 返回删除的哈希元素
     */
    public Info delete(String key){
        if (key!=null && !"".equals(key)){
            //当前元素
            Node current=first;
            Node parent=first;
            while (current!=null && !key.equals(current.getInfo().geteName())){
                if (current.getAfterNode()==null){
                    return null;
                }
                parent=current;
                current=current.getAfterNode();
            }
            if (current!=null){
                if (current==first){
                    first=current.getAfterNode();
                }else {
                    parent.setAfterNode(current.getAfterNode());
                    current.getAfterNode().setBeforeNode(parent);
                }
                return current.getInfo();
            }
        }
        return null;
    }
}
