package com.zcw.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:56 2020/7/22
 */
public class Test7 {
    public static int ceshi(){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] s = line.split(" ");
        int[] arr = new int[n];
        int j = 0;
        for (String s1 : s) {
            arr[j++] = Integer.parseInt(s1);
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hashMap.put(arr[i],i);
        }
        Arrays.sort(arr);

        int count = 1;

        for (int i = arr.length-1; i > 0 ; i--) {
            if (hashMap.get(arr[i]) > hashMap.get(arr[i - 1])){
                count++;
            }else{
                break;
            }
        }
        return arr.length - count;
    }

    public static void main(String[] args) {
        System.out.println(ceshi());
    }
}
