package com.youyuan.list;

/**
 * @author zhangyu
 * @version 1.0
 * @description 双端列表
 * @date 2018/11/1 22:12
 */
public class FirstLastLinkList {
    /**
     * 列表头
     */
    private Node first;
    /**
     * 列表尾
     */
    private Node last;

    /**
     * 从列表头插入信息
     * @param value 要插入的信息
     */
    public void insertFirst(long value){
        Node node=new Node(value);
        if (isEmpty()){
            last=node;
        }
        node.setNext(first);
        first=node;
    }

    /**
     * 从列表尾部添加
     * @param value 添加的信息
     */
    public void insertLast(long value){
        Node node=new Node(value);
        if(isEmpty()){
            last=node;
        }
        last.setNext(node);
        last=node;
    }

    /**
     * 遍历
     */
    public void search(){
        Node current=first;
        if (!isEmpty()){
            while (current!=null){
                current.display();
                current=current.getNext();
            }
        }
        System.out.println("");
    }

    /**
     * 从头部删除
     */
    public void deleteFirst(){
        if (!isEmpty()){
            first=first.getNext();
        }
    }

    /**
     * 根据参数删除
     * @param value 参数值
     */
    public void delete(long value){
        if (!isEmpty()){
            Node current=first;
            Node position=first;
            if (first.getData()==value){
                deleteFirst();
            }else {
                while(current.getData()!=value){
                    position=current;
                    current=current.getNext();
                }
                position.setNext(current.getNext());
            }
        }
    }

    /**
     * 判断列表是否为空
     * @return true空  false非空
     */
    public boolean isEmpty(){
        return first==null;
    }

    public static void main(String[] args) {
        FirstLastLinkList firstLastLinkList=new FirstLastLinkList();
        firstLastLinkList.insertFirst(29L);
        firstLastLinkList.insertFirst(10L);
        firstLastLinkList.insertFirst(98L);
        firstLastLinkList.search();
        System.out.println("===================");
        firstLastLinkList.insertLast(89L);
        firstLastLinkList.insertLast(99L);
        firstLastLinkList.insertLast(16L);
        firstLastLinkList.search();
        System.out.println("===================");
        firstLastLinkList.deleteFirst();
        firstLastLinkList.search();
        System.out.println("===================");
        firstLastLinkList.delete(29L);
        firstLastLinkList.search();
        System.out.println("===================");
        firstLastLinkList.delete(99L);
        firstLastLinkList.search();
    }
}
