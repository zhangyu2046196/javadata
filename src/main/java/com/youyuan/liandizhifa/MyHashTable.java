package com.youyuan.liandizhifa;

import java.math.BigInteger;

/**
 * @author zhangyu
 * @version 1.0
 * @description 哈希表(通过联地址法解决哈希冲突)
 * @date 2018/11/7 14:21
 */
public class MyHashTable {
    /**
     * 数组
     */
    private MyLinkList[] arr;

    public MyHashTable(){
        arr=new MyLinkList[100];
    }

    /**
     * 带参数构造方法
     * @param maxSize 数组大小
     */
    public MyHashTable(int maxSize){
        arr=new MyLinkList[maxSize];
    }

    /**
     * 保存
     * @param info 哈希表元素
     */
    public void insert(Info info){
        if (info!=null){
            int hashVal=hashCode(info.geteName());
            if (arr[hashVal]==null){
                arr[hashVal]=new MyLinkList();
            }
            arr[hashVal].insertFirst(new Node(info));
        }
    }

    /**
     * 根据关键字查询哈希表元素
     * @param key 关键字
     * @return 返回查询的哈希表元素
     */
    public Info getByKey(String key){
        if (key!=null && !"".equals(key)){
            return arr[hashCode(key)].findByKey(key);
        }
        return null;
    }

    /**
     * 根据关键字删除哈希表元素
     * @param key 关键字
     * @return 返回要删除的哈希表元素
     */
    public Info delete(String key){
        if (key!=null && !"".equals(key)){
            return arr[hashCode(key)].delete(key);
        }
        return null;
    }

    /**
     * 计算哈希值
     * @param key 关键字
     * @return 返回计算的哈希值结果
     */
    private int hashCode(String key){
        //默认哈希值为0,因为有幂的连乘数据会非常大,所以用BigInteger
        BigInteger hashVal=new BigInteger("0");
        //幂的连乘基数
        BigInteger pow27=new BigInteger("1");
        for (int i=key.length()-1;i>=0;i--){
            //幂的哈希值等于key的字符的ascci值乘幂的基数
            hashVal.add(new BigInteger(String.valueOf(key.charAt(i)-96)).multiply(pow27));
            //幂的连乘
            pow27=pow27.multiply(new BigInteger(String.valueOf(27)));
        }
        //为了解决哈希值比较大的情况，对哈希值进行压缩，数组的长度取模
        return hashVal.mod(new BigInteger(String.valueOf(arr.length))).intValue();
    }

    public static void main(String[] args) {
        MyHashTable myHashTable=new MyHashTable();
        myHashTable.insert(new Info("a","北京"));
        myHashTable.insert(new Info("ct","上海"));
        myHashTable.insert(new Info("b","深圳"));
        myHashTable.insert(new Info("dt","香港"));
        myHashTable.insert(new Info("bt","澳门"));
        System.out.println("================查询列表=================");
        System.out.println(myHashTable.getByKey("a"));
        System.out.println(myHashTable.getByKey("ct"));
        System.out.println(myHashTable.getByKey("b"));
        System.out.println(myHashTable.getByKey("dt"));
        System.out.println(myHashTable.getByKey("bt"));
        System.out.println("================删除数据=================");
        myHashTable.delete("dt");
        System.out.println("================删除后查询列表============");
        System.out.println(myHashTable.getByKey("a"));
        System.out.println(myHashTable.getByKey("ct"));
        System.out.println(myHashTable.getByKey("b"));
        System.out.println(myHashTable.getByKey("dt"));
        System.out.println(myHashTable.getByKey("bt"));
    }
}
