package com.youyuan.shuzu;

import java.util.Arrays;

/**
 * @author zhangyu
 * @version 1.0
 * @description 数组增删改查
 * @date 2018/10/31 17:24
 */
public class MyArray {
    private long[] arr;
    private int position;
    public MyArray(){
        arr=new long[50];
    }

    /**
     * 增加
     * @param value 增加内容信息
     */
    public void insert(long value){
        arr[position]=value;
        position++;
    }

    /**
     * 遍历数组
     */
    public void display(){
        System.out.print("[");
        for (int i=0;i<position;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("]");
    }

    /**
     * 根据内容查询数据下标
     * @param value 数据内容
     * @return 下标
     */
    public int searchByValue(long value){
        int i;
        for(i=0;i<position;i++){
            if(arr[i]==value){
                break;
            }
        }
        return i;
    }

    /**
     * 根据数组下标查询数组内容
     * @param index 数组下标
     * @return 数组内容
     * @throws Exception
     */
    public long searchByIndex(int index) throws Exception {
        if (index>=position || index<0){
            throw new Exception("数组下标越界"+index);
        }
        return arr[index];
    }

    /**
     * 修改数组内容
     * @param index 下标
     * @param newValue 更新的数组内容
     * @throws Exception
     */
    public void update(int index,long newValue) throws Exception {
        if (index>=position || index<0){
            throw new Exception("数组下标越界"+index);
        }
        arr[index]=newValue;
    }

    /**
     * 删除数据  就是把原来数据向前移动
     * @param index
     * @throws Exception
     */
    public void delete(int index) throws Exception {
        if (index>=position || index<0){
            throw new Exception("数组下标越界"+index);
        }
        for (int i=index;i<position;i++){
            arr[index]=arr[index+1];
            position--;
        }
    }

    /**
     * 根据二分查找方法查找数据  (二分查找数据数组必须是排序好的数组)
     * @param value 查询参数
     * return 返回数组下标
     */
    public int bsearch(long value){
        int midden=0;//中间下标
        int low=0;//最左下标
        int pow=position;//最右下标
        while(true){
            midden=(low+pow)/2;
            if (arr[midden]==value){
                return midden;
            }else if(low>pow){
                return -1;
            }else{
                if(arr[midden]>value){
                    pow=midden-1;
                }else{
                    low=midden+1;
                }
            }
        }
    }
}
