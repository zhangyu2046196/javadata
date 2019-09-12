package com.youyuan.paixu;

/**
 * @author zhangyu
 * @version 1.0
 * @description 快速排序
 * @date 2018/11/5 15:24
 */
public class QuickSort {
    /**
     * 划分数组，小于关键字的放在数组左边，大于关键字的放在数组右边
     * @param arr 数组
     * @param left 数组最左边下标
     * @param right 数组最右边下标
     * @param point 关键字
     * @return 返回关键字下标
     */
    public static int partition(long arr[],int left, int right,long point) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while(true) {
            //循环,将比关键字小的留在左端
            while(leftPtr < rightPtr && arr[++leftPtr] < point);
            //循环，将比关键字大的留在右端
            while(rightPtr > leftPtr && arr[--rightPtr] > point);
            if(leftPtr >= rightPtr) {
                break;
            } else {
                long tmp = arr[leftPtr];
                arr[leftPtr] =  arr[rightPtr];
                arr[rightPtr] = tmp;
            }
        }
        //将关键字和当前leftPtr所指的这一个进行交换
        long tmp = arr[leftPtr];
        arr[leftPtr] =  arr[right];
        arr[right] = tmp;
        return leftPtr;
    }

    /**
     * 打印数组元素
     * @param arr 数组
     */
    public static void displayArr(long[] arr) {
        System.out.print("[");
        for(long num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }

    /**
     * 递归排序方法
     * @param arr 排序数组
     * @param left 数组左边下标
     * @param right 数组右边下标
     */
    public static void sort(long[] arr, int left, int right) {
        if(right - left <= 0) {
            return;
        } else {
            //设置关键字,数组最右边元素关键字
            long point = arr[right];
            //获得切入点，同时对数组进行划分
            int partition = partition(arr, left, right, point);
            //对左边的子数组进行快速排序
            sort(arr,left,partition - 1);
            //对右边的子数组进行快速排序
            sort(arr,partition + 1, right);
        }
    }

    public static void main(String[] args) {
        long[] arr  = new long[10];
        for(int i = 0; i < 10;i++) {
            arr[i] = (long) (Math.random() * 99);
        }

        QuickSort.displayArr(arr);

        QuickSort.sort(arr, 0, arr.length - 1);

        QuickSort.displayArr(arr);
    }
}
