package com.youyuan.paixu;

/**
 * @author zhangyu
 * @version 1.0
 * @description 希尔排序
 * @date 2018/11/5 14:26
 */
public class ShellSort {
    /**
     * 希尔排序方法
     * @param arr 排序数组
     */
    public static void sort(long[] arr) {
        //初始化一个间隔
        int h = 1;
        //计算最大间隔
        while(h < arr.length / 3) {
            h = h * 3 + 1;
        }

        while(h > 0) {
            //进行插入排序
            long tmp = 0;
            for(int i = h; i < arr.length; i++) {
                tmp = arr[i];
                int j = i;
                while(j > h - 1 && arr[j - h] >= tmp) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = tmp;
            }
            //减小间隔
            h = (h - 1) / 3;
        }
    }

    public static void main(String[] args) {
        long[] arr = new long[10];
        arr[0] = 90;
        arr[1] = 12;
        arr[2] = 23;
        arr[3] = 15;
        arr[4] = -4;
        arr[5] = 1;
        arr[6] = 97;
        arr[7] = 4;
        arr[8] = 3;
        arr[9] = 8;

        System.out.print("[");
        for(long num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();

        ShellSort.sort(arr);

        System.out.print("[");
        for(long num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
