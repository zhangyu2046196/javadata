package com.youyuan.digui;

/**
 * @author zhangyu
 * @version 1.0
 * @description 第一项为0 第二项为1 后面第n项的值为n-1项的值加上n-2项的值
 * @date 2018/11/5 12:25
 */
public class Fibonacci {

    /**
     * 递归计算fibonacci数列
     * @param n
     * @return
     */
    public static int getNumber(int n){
        if (n==1){
            return 0;
        }else if (n==2){
            return 1;
        }else {
            return getNumber(n-1)+getNumber(n-2);
        }
    }

    public static void main(String[] args) {
        System.out.println(getNumber(6));
    }
}
