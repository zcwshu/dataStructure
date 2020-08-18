package com.zcw.test;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:53 2020/7/22
 */
public class Test1 {
    public static void main(String[] args) {
        //List<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        int temp1 = 0;
        int temp2 = 0;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String line = sc.nextLine();
        String[] s = line.split(" ");
        int[] arr = new int[n];
        int j = 0;
        for (String s1 : s) {
            arr[j++] = Integer.parseInt(s1);
        }

        Arrays.sort(arr);//数组排序

        for(int i = 0;i < arr.length;i++){
            if (arr[arr.length-i-1] == arr[arr.length-i-2]){
                temp1 = arr[arr.length-i-1];
                count = arr.length-i;
            }
            count++;
        }

    }
}

