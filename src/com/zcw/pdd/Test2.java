package com.zcw.pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:07 2020/8/2
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int[] arr1 = new int[3];
        String[] s1 = str.split(" ");
        for (int i = 0; i < 3; i++) {
            arr1[i] = Integer.parseInt(s1[i]);
        }

        List<String> list = new ArrayList<>();
        Scanner sc2 = new Scanner(System.in);
        for (int i = 0; i < arr1[0] + arr1[1]; i++) {
            list.add(sc2.nextLine());
        }
        int[] zx = new int[arr1[0]];
        int[] zy = new int[arr1[0]];
        int[] wx = new int[arr1[1]];
        int[] wy = new int[arr1[1]];
        for (int i = 0; i < list.size(); i++) {
            if (i < arr1[0]){
                zx[i] = Integer.parseInt(list.get(i).split(" ")[0]);
                zy[i] = Integer.parseInt(list.get(i).split(" ")[1]);
            }else{
                for (int j = 0; j < arr1[1]; j++) {
                    wx[j] = Integer.parseInt(list.get(i).split(" ")[0]);
                    wy[j] = Integer.parseInt(list.get(i).split(" ")[1]);
                }
            }
        }

        int m = Integer.MAX_VALUE;
        for (int i = 0; i < arr1[0]; i++) {
            for (int j = 0; j < arr1[1]; j++) {
                if (zy[i] + wy[j] >= arr1[2]){
                    m = Math.min(m,zx[i] + wx[j]);
                }
            }
        }
        System.out.println(m);
    }
}
