package com.youyuan.list;

/**
 * @author zhangyu
 * @version 1.0
 * @description 双向链表 链表中保存头节点和尾节点的引用，并且每个节点记录上一个节点和下一个节点
 * @date 2018/11/2 11:21
 */
public class DoubleLinkList {
    /**
     * 头节点
     */
    private DoubleNode first;
    /**
     * 尾节点
     */
    private DoubleNode last;

    /**
     * 从头部添加
     * @param value 参数值
     */
    public void insertFirst(long value){
        DoubleNode doubleNode=new DoubleNode(value);
        if (isEmpty()){
            last=doubleNode;
        }else {
            first.setBefore(doubleNode);
            doubleNode.setAfter(first);
        }
        first=doubleNode;
    }

    /**
     * 从尾部添加
     * @param value 参数值
     */
    public void insertLast(long value){
        DoubleNode doubleNode=new DoubleNode(value);
        if (isEmpty()){
            first=doubleNode;
        }else {
            last.setAfter(doubleNode);
            doubleNode.setBefore(last);
        }
        last=doubleNode;
    }

    /**
     * 从头删除数据
     */
    public void deleteFirst(){
        if (!isEmpty()){
            if (first.getAfter()==null){
                first=null;
                last=null;
            }else {
                first.getAfter().setBefore(null);
                first=first.getAfter();
            }
        }
    }

    /**
     * 从尾删除数据
     */
    public void deleteLast(){
        if (!isEmpty()){
            if (last.getBefore()==null){
                first=null;
                last=null;
            }else {
                last.getBefore().setAfter(null);
                last=last.getBefore();
            }
        }
    }

    /**
     * 根据参数删除
     * @param value 数据
     */
    public void remove(long value){
        if (!isEmpty()){
            DoubleNode current=null;
            current=first;
            while(current!=null){
                if (current.getDate()==value){
                    current.getBefore().setAfter(current.getAfter());
                    current.getAfter().setBefore(current.getBefore());
                    break;
                }
                current=current.getAfter();
            }
        }
    }

    /**
     * 遍历
     */
    public void search(){
        if (first!=null){
            DoubleNode current=null;
            current=first;
            while(current!=null){
                current.display();
                current=current.getAfter();
            }
        }
        System.out.println("");
    }

    /**
     * 判断链表是否为空
     * @return true 空 false 非空
     */
    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args) {
        DoubleLinkList doubleLinkList=new DoubleLinkList();
        doubleLinkList.insertFirst(29L);
        doubleLinkList.insertFirst(98L);
        doubleLinkList.insertFirst(78);
        doubleLinkList.search();
        System.out.println("===================");
        doubleLinkList.insertLast(99L);
        doubleLinkList.insertLast(89L);
        doubleLinkList.insertLast(102L);
        doubleLinkList.search();
        System.out.println("===================");
        doubleLinkList.deleteFirst();
        doubleLinkList.search();
        System.out.println("===================");
        doubleLinkList.deleteLast();
        doubleLinkList.search();
        System.out.println("===================");
        doubleLinkList.remove(29L);
        doubleLinkList.search();
    }
}
