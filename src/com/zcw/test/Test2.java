package com.zcw.test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:13 2020/7/22
 */
public class Test2 {
    public static void main(String[] args) {
        int temp1,temp2;
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] str = new int[m];
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {

            if (str[str.length-i-1] == str[str.length-i-2]){
                temp1 = str[str.length-i-1];
            }
            str = str;
        }

    }
}
