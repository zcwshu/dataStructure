package com.zcw.test;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 21:21 2020/7/28
 */
public class Test9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] arr = s.split(" ");
        Long a = Long.parseLong(arr[0]);
        int b = Integer.parseInt(arr[1]);
        int day =0;
        while(true){
            if (a >= 10000000000000000L){
                break;
            }
            a += a * b + 1;
            day++;
        }
        System.out.println(day);
    }
}
