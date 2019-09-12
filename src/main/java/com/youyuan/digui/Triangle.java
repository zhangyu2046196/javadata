package com.youyuan.digui;

/**
 * @author zhangyu
 * @version 1.0
 * @description 三角数 第n项的值等于第n-1项的值加上第n的数字
 * @date 2018/11/5 12:15
 */
public class Triangle {

    /**
     * 通过循环的方式计算
     * @param n 第几项
     * @return 返回计算结果
     */
    public static int getNumber1(int n){
        int total=0;
        while (n>0){
            total=total+n;
            n--;
        }
        return total;
    }

    /**
     * 通过递归的算法计算
     * @param n 第几项
     * @return 返回计算结果
     */
    public static int getNumber2(int n){
        if (n==1){
            return 1;
        }else {
            return getNumber2(n-1)+n;
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber1(6));
        System.out.println(getNumber2(6));
    }
}
