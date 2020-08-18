package com.zcw.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 21:29 2020/8/1
 * 输入练习
 */
public class Test10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("使用next方法接收:");

        Integer i01 = -128;
        int i02 = -128;
        Integer i03 = Integer.valueOf(-128);
        Integer i04 = new Integer((-128));

        System.out.println(i02 == i04);
        System.out.println(i02 == i01);
        System.out.println(i03 == i04);
        System.out.println(i01 == i03);

    }
}
