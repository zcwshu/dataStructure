package com.zcw.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:37 2020/6/24
 */
public class GenericDemo {
    public static void main(String[] args) {
        //show1();
        show2();
    }

    private static void show2() {
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("abc");
        for (String s:list){
            System.out.println(s);
        }
    }

    private static void show1() {
        ArrayList list = new ArrayList();
        list.add("abc");
        list.add(1);
        Iterator it = list.iterator();
        while(it.hasNext()){
            Object obj = it.next();
            System.out.println(obj);
            //想要使用Stirng类的特有方法,length获取字符串长度,多态Object obj = "abc",不能使用子类的方法
            //需要向下转型
            String s = (String)obj;
            System.out.println(s);
        }

    }
}
