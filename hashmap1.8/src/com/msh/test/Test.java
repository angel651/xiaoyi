package com.msh.test;

import java.util.HashMap;
/*
*  @author : gnnu-lxz
* */
public class Test {
    //这是main方法的程序入口
    public static void main(String[] args) {            //16*0.75=12(阈值)
        //定义HashMap集合
        HashMap<String,Integer> map = new HashMap<>(10);//数组+链表+红黑树
        //集合中添加元素:
        System.out.println(map.put("通话", 10));
        System.out.println(map.put("随便", 20));
        System.out.println(map.put("通话", 30));
        System.out.println(map.put("重地", 40));
        System.out.println(map.size());
        System.out.println(map);

        System.out.println("通话".hashCode());
        System.out.println("重地".hashCode());
     /*   static final int tableSizeFor(int cap) {
            int n = cap - 1;
            n |= n >>> 1;
            n |= n >>> 2;
            n |= n >>> 4;
            n |= n >>> 8;
            n |= n >>> 16;
            return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        }*/






    }
}
