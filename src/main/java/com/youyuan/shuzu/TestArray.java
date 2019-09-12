package com.youyuan.shuzu;

/**
 * @author zhangyu
 * @version 1.0
 * @description 数组数据结构测试
 * @date 2018/10/31 17:43
 */
public class TestArray {
    public static void main(String[] args) throws Exception {
        MyArray myArray=new MyArray();
        myArray.insert(23L);
        myArray.insert(39L);
        myArray.insert(78L);
        myArray.insert(92L);
        myArray.insert(99L);
        myArray.display();
        /*System.out.println("===========");
        System.out.println(myArray.searchByIndex(1));
        System.out.println("===========");
        System.out.println(myArray.searchByValue(89L));
        System.out.println("===========");
        myArray.update(0,97);
        myArray.display();
        System.out.println("===========");
        myArray.delete(1);
        myArray.display();*/
        System.out.println("以下为二分查找");
        System.out.println("二分查找下标:"+myArray.bsearch(92L));

    }
}
