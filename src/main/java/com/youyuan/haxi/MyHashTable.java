package com.youyuan.haxi;

import java.math.BigInteger;

/**
 * @author zhangyu
 * @version 1.0
 * @description 哈希表实现类
 * @date 2018/11/6 19:34
 */
public class MyHashTable {

    private Info[] arr;

    /**
     * 无参构造方法
     */
    public MyHashTable() {
        arr=new Info[100];
    }

    /**
     * 有参构造方法
     * @param maxSize 数组大小
     */
    public MyHashTable(int maxSize){
        arr=new Info[maxSize];
    }

    /**
     * 插入
     * @param info 插入实体
     */
    public void insert(Info info){
        arr[hashCode(info.geteName())]=info;
    }

    /**
     * 通过关键字查询数组元素
     * @param key 关键字转换成哈希值
     * @return 返回查询结果
     */
    public Info find(String key){
        return arr[hashCode(key)];
    }

    /**
     * 通过key计算哈希值,做为数组的下标
     * @param key 索引值
     * @return 返回哈希值做为数组下标
     */
    public int hashCode(String key){
        /*//将key的ascii码相加  缺点是很容易重复
        int val=0;//总数
        int letter=0;//ascii值
        for (int i=key.length()-1;i>=0;i--){
            letter=key.charAt(i)-96;
            val+=letter;
        }
        return val;*/

        //幂的连乘计算哈希值  缺点值太大数组大小不好把控且数组下标不相连
/*        int val=0;//总数
        int pow27=27;//幂的基数
        int letter=0;//ascii码
        for (int i=key.length()-1;i>=0;i--){
            letter=key.charAt(i)-96;
            val+=letter*pow27;
            pow27=pow27*2;
        }
        return val;*/

/*        //压缩哈希值  缺点 哈希值很容易重复
        int val=0;//总数
        int pow27=27;//幂的基数
        int letter=0;//ascii码
        for (int i=key.length()-1;i>=0;i--){
            letter=key.charAt(i)-96;
            val+=letter*pow27;
            pow27=pow27*2;
        }
        return val% arr.length;*/

        BigInteger valB=new BigInteger("0");//总数
        BigInteger pow27B=new BigInteger("1");//幂的基数
        BigInteger letterB=null;//ascii码
        for (int i=key.length()-1;i>=0;i--){
            letterB=new BigInteger(String.valueOf(key.charAt(i)-96));
            valB=valB.add(letterB.multiply(pow27B));
            pow27B=pow27B.multiply(new BigInteger(String.valueOf(27)));
        }
        return valB.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }

    public static void main(String[] args) {
        MyHashTable myHashTable=new MyHashTable();
        myHashTable.insert(new Info("beijing","北京"));
        myHashTable.insert(new Info("shanghai","上海"));
        myHashTable.insert(new Info("shenzhen","深圳"));
        System.out.println(myHashTable.find("beijing"));
        System.out.println(myHashTable.find("shanghai"));
        System.out.println(myHashTable.find("shenzhen"));
    }
}
