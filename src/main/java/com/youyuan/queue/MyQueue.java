package com.youyuan.queue;

import com.youyuan.zhan.MyStack;

/**
 * @author zhangyu
 * @version 1.0
 * @description 循环队列 先进先出,根据判断队头和队尾,如果队尾达到数组最大值时队尾指向队头重新添加数据
 * @date 2018/11/1 15:01
 */
public class MyQueue {

    /**
     * 数组
     */
    private long[] arr;
    /**
     * 数组有效个数
     */
    private int position;
    /**
     * 队头下标
     */
    private int front;
    /**
     * 队尾下标
     */
    private int end;

    public MyQueue(){
        arr=new long[10];
        front=0;
        end=-1;
        position=0;
    }

    /**
     * 带参数的构造方法
     * @param maxsize 初始化数组大小
     */
    public MyQueue(int maxsize){
        arr=new long[maxsize];
        front=0;
        end=-1;
        position=0;
    }

    /**
     * 往队列添加数据
     * @param value 要添加的信息
     */
    public void insert(long value){
        if (end==arr.length-1){
            end=-1;
        }
        arr[++end]=value;
        position++;
    }

    /**
     * 删除数据
     * @return 返回删除的数据
     */
    public long remove(){
        if (front==arr.length){
            front=0;
        }
        position--;
        return arr[front++];
    }

    /**
     * 查询数据
     * @return 返回查询结果
     */
    public long peek(){
        return arr[front];
    }

    /**
     * 判断队列是否为空
     * @return true 空 false 非空
     */
    public boolean isEmplt(){
        return position<=0;
    }

    /**
     * 判断队列是否满
     * @return true 满 false 不满
     */
    public boolean isFull(){
        return position==arr.length;
    }

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue(5);
        myQueue.insert(19L);
        myQueue.insert(8L);
        myQueue.insert(98L);
        myQueue.insert(-2L);
        myQueue.insert(37L);
        System.out.println("=========队列是否为空=========="+myQueue.isEmplt());
        System.out.println("=========队列是否满============"+myQueue.isFull());
        System.out.println("=========查询数据=============="+myQueue.peek());
        System.out.println("=========删除数据==============");
        System.out.print("[");
        while (!myQueue.isEmplt()){
            System.out.print(myQueue.remove()+" ");
        }
        System.out.println("]");
        System.out.println("=========重新添加==============");
        myQueue.insert(19L);
        myQueue.insert(8L);
        myQueue.insert(98L);
        myQueue.insert(-2L);
        myQueue.insert(37L);
        System.out.print("[");
        while (!myQueue.isEmplt()){
            System.out.print(myQueue.remove()+" ");
        }
        System.out.println("]");
    }
}
