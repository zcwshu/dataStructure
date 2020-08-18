package com.zcw;

import java.util.HashSet;

/**
 * @Author: AndrewBar
 * @Date: Created in 15:30 2020/8/13
 */
public class Test {
    public static void main(String[] args) {
//        float f = 1.1;
//        double d = 5.3e12;
//        String s1 = "hello";
//        String s2 = "hello";
//        String s3 = new String("hello");
//        String s4 = new String(hello + " ");
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s3));
//        System.out.println((Math.abs(-2) + Math.ceil(-5.3) + Math.round(-3.5)));
        HashSet<Short> s = new HashSet<>();
        for (short i = 0; i < 100; i++) {
            s.add(i);
            s.remove(i-1);
        }
        System.out.println(s.size());
    }
}
