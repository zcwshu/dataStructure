package com.zcw.notecode;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:34 2020/8/13
 */
public class T {
    public static void main(String[] args) {
        //Object o = new Object();            //半初始化
        int num = 15;
        while(num > 0){
            System.out.print(num++ %5+ "\t");
            num /= 5;
        }
    }
}
