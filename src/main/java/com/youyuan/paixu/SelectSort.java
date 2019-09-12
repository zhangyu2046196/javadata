package com.youyuan.paixu;

/**
 * @author zhangyu
 * @version 1.0
 * @description 选择排序
 * @date 2018/10/31 22:06
 */
public class SelectSort {

    /**
     * 选择排序 实现思路: 先循环一遍，定义一个下标k,里面嵌套循环,每次k指向最小值的下标,然后和外面循环的值替换，因为外面循环的值下标是从0开始
     * @param arr
     * @return
     */
    public static long[] sort(long[] arr){
        int k=0;//存储最小值的下标
        long temp=0L;//存储替换时的临时数据
        for (int i=0;i<arr.length;i++){
            k=i;
            for (int j=i;j<arr.length;j++){
                if(arr[j]<arr[k]){
                    k=j;
                }
            }
            temp=arr[i];
            arr[i]=arr[k];
            arr[k]=temp;
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
