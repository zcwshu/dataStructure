package com.zcw.tree;

import java.util.ArrayList;

/**
 * @Author: AndrewBar
 * @Date: Created in 22:45 2020/7/14
 */
public class Test {
    public static void main(String[] args) {

        int a = 500000000;
        int b = 600000000;
        int sum = 0;
        for (int i = 1; i <= b; i++) {
            sum = sum + a / i;
        }
        System.out.println(sum);
        ArrayList arrayList = new ArrayList();
    }
}
