package com.youyuan.kaifangdizhifa;

import java.math.BigInteger;

/**
 * @author zhangyu
 * @version 1.0
 * @description 开放地址法解决哈希表哈希值冲突问题，将要插入的数据的下标向下移动，直到找到为空的值的下标，然后插入数据
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
     * 开发地址法保存数据
     * @param info 插入实体
     */
    public void insert(Info info){
        int hashVal=hashCode(info.geteName());
        while(arr[hashVal]!=null && arr[hashVal].getzName()!=null){
            ++hashVal;
            hashVal %=arr.length;
        }
        arr[hashVal]=info;
    }

    /**
     * 通过关键字的开放地址法计算哈希值查询数组元素
     * @param key 关键字转换成哈希值
     * @return 返回查询结果
     */
    public Info find(String key){
        int hashVal=hashCode(key);
        while (arr[hashVal]!=null){
            if (arr[hashVal].geteName().equals(key)){
                return arr[hashVal];
            }
            ++hashVal;
            hashVal %=arr.length;
        }
        return null;
    }

    /**
     * 根据key计算哈希值删除数据
     * @param key 关键字
     * @return 返回要删除的数据
     */
    public Info delete(String key){
        int hashVal = hashCode(key);
        while(arr[hashVal] != null) {
            if(arr[hashVal].geteName().equals(key)) {
                Info tmp = arr[hashVal];
                tmp.setzName(null);
                return tmp;
            }
            ++hashVal;
            hashVal %= arr.length;
        }
        return null;
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
        myHashTable.insert(new Info("a","北京"));
        myHashTable.insert(new Info("ct","上海"));
        myHashTable.insert(new Info("b","深圳"));
        System.out.println(myHashTable.find("a"));
        System.out.println(myHashTable.find("ct"));
        System.out.println(myHashTable.find("b"));
        System.out.println("============删除数据==============");
        System.out.println("============查询数据列表===============");
        myHashTable.delete("a");
        System.out.println(myHashTable.find("a"));
        System.out.println(myHashTable.find("ct"));
        System.out.println(myHashTable.find("b"));
    }
}
