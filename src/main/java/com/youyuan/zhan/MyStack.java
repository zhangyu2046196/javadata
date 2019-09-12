package com.youyuan.zhan;

/**
 * @author zhangyu
 * @version 1.0
 * @description 栈   栈的特点:先进后出 后近先出
 * @date 2018/11/1 11:32
 */
public class MyStack {
    /**
     * 数组
     */
    private long[] arr;
    /**
     * 数组下标
     */
    private int top;
    public MyStack(){
        arr=new long[10];
        top=-1;
    }
    public MyStack(int maxsize){
        arr=new long[maxsize];
        top=-1;
    }
    /**
     * 添加数据
     * @param value 添加的数据信息
     */
    public void push(long value){
        arr[++top]=value;
    }
    /**
     * 移除数据 返回最后一个数据后 top指针减一
     * @return 返回移除的数据
     */
    public long pop(){
        return arr[top--];
    }
    /**
     * 查询数据
     * @return 返回最后一条数据
     */
    public long peek(){
        return arr[top];
    }

    /**
     * 判断是否为空
     * @return true 空 false非空
     */
    public boolean isEmpty(){
        return top==-1;
    }

    /**
     * 判断是否已满
     * @return true 满  false不满
     */
    public boolean isFull(){
        return top==arr.length-1;
    }

    public static void main(String[] args) {
        MyStack myStack=new MyStack(5);
        myStack.push(19L);
        myStack.push(8L);
        myStack.push(98L);
        myStack.push(-2L);
        myStack.push(37L);
        System.out.println("=========初始数组数据==========");
        System.out.println("=========数组是否为空=========="+myStack.isEmpty());
        System.out.println("=========数组是否满============"+myStack.isFull());
        System.out.println("=========移除一个数字=========="+myStack.pop());
        System.out.println("=========数组是否满============"+myStack.isFull());
        System.out.println("=========显示最后一个数字======="+myStack.peek());
    }

}
