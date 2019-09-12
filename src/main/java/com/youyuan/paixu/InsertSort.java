package com.youyuan.paixu;

/**
 * @author zhangyu
 * @version 1.0
 * @description 插入排序
 * @date 2018/10/31 22:55
 */
public class InsertSort {

    /**
     * 插入排序
     * @param arr 排序数组
     * @return 返回排序结构
     */
    public static long[] sort(long[] arr) {
        long tmp = 0;

        for(int i = 1; i < arr.length; i++) {
            tmp = arr[i];
            int j = i;
            while(j > 0 && arr[j] >= tmp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = tmp;
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
