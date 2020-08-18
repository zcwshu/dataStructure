package com.zcw.test;

import org.omg.CORBA.StringHolder;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 21:06 2020/7/28
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = -1;
        int res = 0;
        int l = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < l; i++) {
            String s = scanner.nextLine();
            String[] str = s.split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            res +=(m - n);
            max = Math.max(res,max);
        }
        System.out.println(res);
        System.out.println(max);
    }
}
