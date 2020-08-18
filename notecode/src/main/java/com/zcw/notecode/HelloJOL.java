package com.zcw.notecode;

import org.openjdk.jol.info.ClassLayout;
/**
 * @Author: AndrewBar
 * @Date: Created in 15:06 2020/8/10
 */
public class HelloJOL {
    public static void main(String[] args) throws InterruptedException {

        Thread.sleep(5000);

        Object o = new Object();
        String s = ClassLayout.parseInstance(o).toPrintable();
        System.out.println(s);

        //o.hashCode();

        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
