package com.youyuan.hannuota;

/**
 * @author zhangyu
 * @version 1.0
 * @description 汉诺塔问题，所有盘子从A塔移动到C塔,要求每次只移动一个盘子,要求移动的盘子不能放在比自己小的盘子上面
 * @date 2018/11/5 13:19
 */
public class Hannuota {

    /**
     * 汉诺塔移动方法,递归调用
     * @param topNum 盘子数量
     * @param from 起始塔
     * @param inter 中间塔
     * @param to 目标塔 名字
     */
    public static void moveTa(int topNum,String from,String inter,String to){
        if (topNum==1){
            System.out.println("盘子"+topNum+"从"+from+"塔,移动到"+to+"塔");
        }else {
            moveTa(topNum-1,from,to,inter);
            System.out.println("盘子"+topNum+"从"+from+"塔,移动到"+to+"塔");
            moveTa(topNum-1,inter,from,to);
        }
    }

    public static void main(String[] args) {
        moveTa(5,"A","B","C");
    }
}
