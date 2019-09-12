package com.youyuan.list;

/**
 * @author zhangyu
 * @version 1.0
 * @description 自定义链表,链表是每次新加入的都放到链表的头部,并且每个节点保存下一个节点引用
 * @date 2018/11/1 17:45
 */
public class MyLinkList {
    /**
     * 头节点
     */
    private Node first;

    /**
     * 添加节点信息
     * @param value
     */
    public void insert(long value){
        Node node=new Node(value);
        node.setNext(first);
        first=node;
    }

    /**
     * 查询
     */
    public void search(){
        if (first!=null){
            Node current=first;
            while (current!=null){
                current.display();
                current=current.getNext();
            }
        }
        System.out.println("");
    }

    /**
     * 根据数据删除
     * @param value 数据
     * @return 返回删除的数据
     */
    public void remove(long value){
        if(first!=null){
            Node current=first;
            Node position=first;
            if (first.getData()==value){
                first=first.getNext();
            }else{
                while (current.getData()!=value){
                    position=current;
                    current=current.getNext();
                }
                position.setNext(current.getNext());
            }
        }
    }

    /**
     * 根据数据查询
     * @param value 数据
     * @return
     */
    public Node searchByValue(long value){
        Node current=first;
        if(first!=null){
            while (current!=null){
                if(current.getData()==value){
                    return current;
                }else{
                    current=current.getNext();
                }
            }
        }
        return null;
    }

    /**
     * 删除第一个
     */
    public void removeFirst(){
        first=first.getNext();
    }

    public static void main(String[] args) {
        MyLinkList myLinkList=new MyLinkList();
        myLinkList.insert(20L);
        myLinkList.insert(16L);
        myLinkList.insert(98L);
        myLinkList.insert(80L);
        myLinkList.insert(102L);
        myLinkList.insert(91L);
        myLinkList.search();
        System.out.println("=======================");
        //myLinkList.removeFirst();
        myLinkList.remove(16L);
        myLinkList.search();
/*        Node node=myLinkList.searchByValue(16L);
        if (node!=null){
            node.display();
        }*/
        System.out.println("=======================");
        myLinkList.remove(80L);
        myLinkList.search();
    }
}
