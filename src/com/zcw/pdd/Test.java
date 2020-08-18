package com.zcw.pdd;

import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 19:05 2020/8/2
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        int[] arr1 = new int[2];                //输入的第一行
        String[] ss1 = s1.split(" ");
        arr1[0] = Integer.parseInt(ss1[0]);
        arr1[1] = Integer.parseInt(ss1[1]);

        String s2 = sc.nextLine();
        int[] arr2 = new int[arr1[1]];            //输入的第二行
        String[] ss2 = s2.split(" ");
        for (int i = 0; i < ss2.length; i++) {
            arr2[i] = Integer.parseInt(ss2[i]);
        }

        System.out.println(test(arr1, arr2));
    }

    public static String test(int[] arr1, int[] arr2) {
        String  str = "";
        int step = 0;      //回退次数
        int temp = arr1[0];//相距的距离 10 2   6 3

        for (int i = 0; i < arr2.length; i++) {
            if (temp - arr2[i] < 0){
                step++;
            }
            temp = Math.abs(temp - arr2[i]);
            if (temp == 0){
                str =  "paradox";
                break;////////////////////////////////一定要结束
            }else{
                str =  temp +" " +step;
            }
        }
        return str;
    }
}
