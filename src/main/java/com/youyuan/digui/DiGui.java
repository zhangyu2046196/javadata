package com.youyuan.digui;

/**
 * @author zhangyu
 * @version 1.0
 * @description 递归  方法里面还调用本方法
 * @date 2018/11/5 12:05
 */
public class DiGui {
    public static void test(){
        System.out.println("hello world");
        test();
    }

    public static void main(String[] args) {
        test();
    }
}
