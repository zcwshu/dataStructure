package com.zcw.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:37 2020/6/24
 */
public class IteratorDemo {
    public static void main(String[] args) {
        //创建集合对象
        Collection<String> collection = new ArrayList<>();
        //往集合中添加元素
        collection.add("姚明");
        collection.add("麦迪");
        collection.add("科比");
        collection.add("詹姆斯");
        collection.add("艾弗森");
        //迭代器泛型跟着迭代器走
        //多态:接口         =        实现类对象
        Iterator<String> iter = collection.iterator();

        while(iter.hasNext()){
            String e = iter.next();
            System.out.println(e);
        }
        /*Iterator<String> iterator = collection.iterator();
        for (collection.iterator();iterator.hasNext();){
            String next = iterator.next();
            System.out.println(next);
        }*/

        //数据类型 变量名 : 容器名
        for (String ss:collection){
            System.out.println(ss);
        }

        int[] arr = {1,2,3,4,5,6,7};
        for (int i:arr){
            System.out.println(i);
        }

        /*boolean b = iter.hasNext();
        System.out.println(b);
        String next = iter.next();
        System.out.println(next);

        b = iter.hasNext();
        System.out.println(b);
        next = iter.next();
        System.out.println(next);

        b = iter.hasNext();
        System.out.println(b);
        next = iter.next();
        System.out.println(next);

        b = iter.hasNext();
        System.out.println(b);
        next = iter.next();
        System.out.println(next);

        b = iter.hasNext();
        System.out.println(b);
        next = iter.next();
        System.out.println(next);*/
    }
}
