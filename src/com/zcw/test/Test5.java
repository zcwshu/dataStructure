package com.zcw.test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:28 2020/7/22
 */
public class Test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        //大顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o2, o1) -> (o2-o1)));
        String line = sc.nextLine();
        String[] s = line.split(" ");
        for(String s1 : s){
            pq.add(Integer.parseInt(s1));
        }

        int a[] = new int[2];
        int b[] = new int[2];

        if(!pq.isEmpty()) a[0] = pq.poll();
        if(!pq.isEmpty()) a[1] = pq.poll();
        while(a[0] != a[1] && !pq.isEmpty()){
            a[0] = a[1];
            a[1] = pq.poll();
        }
        if(pq.isEmpty() || a[0] != a[1]){
            System.out.println(-1);
            return;
        }


        if(!pq.isEmpty()) b[0] = pq.poll();
        if(!pq.isEmpty()) b[1] = pq.poll();

        while(b[0] != b[1] && !pq.isEmpty()){
            b[0] = b[1];
            b[1] = pq.poll();
        }

        if(b[1] != b[0]){
            System.out.println(-1);
            return;
        }
        else
            System.out.println(a[0] * b[0]);
        return ;
    }
}
