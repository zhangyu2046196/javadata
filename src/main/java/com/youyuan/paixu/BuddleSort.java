package com.youyuan.paixu;

/**
 * @author zhangyu
 * @version 1.0
 * @description 冒泡排序
 * @date 2018/10/31 21:33
 */
public class BuddleSort {

    /**
     * 冒泡排序
     * @param arr 参数数组  实现思路:整体循环一遍，里面嵌套从最后一个和倒数第二个对比替换
     * @return 返回排序后的数组
     */
    public static long[] sort(long[] arr){
        long temp=0L;//临时存放数据
        for (int i=0;i<arr.length;i++){
            for (int j=arr.length-1;j>0;j--){
                if (arr[j]<arr[j-1]){
                    temp=arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        long[] arr=new long[5];
        arr[0]=19L;
        arr[1]=6L;
        arr[2]=98L;
        arr[3]=-2L;
        arr[4]=37L;
        System.out.print("[");
        for (long num:arr){
            System.out.print(num+" ");
        }
        System.out.println("]");

        sort(arr);

        System.out.println("排序后结果");
        System.out.print("[");
        for (long num:arr){
            System.out.print(num+" ");
        }
        System.out.println("]");
    }
}
