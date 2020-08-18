package com.zcw.test;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 17:14 2020/8/2
 */
public class pdd1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(cal(sc.nextInt()));
        }

    }

    public static int cal(int n){
        if (n == 1){
            return 1;
        }else if (n == 2){
            return 2;
        }else{
            return 1 + cal(n % 3);
        }
    }

}
