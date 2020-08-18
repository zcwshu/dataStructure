package com.zcw;

import java.util.ArrayList;

/**
 * @Author: AndrewBar
 * @Date: Created in 16:36 2020/8/12
 */

//Dump文件
public class Demo3 {
    byte[] arr = new byte[1*1024*1024];
    public static void main(String[] args) {
        ArrayList<Demo3> list = new ArrayList<>();
        int count = 0;

        try{
            while(true){
                list.add(new Demo3());
                count++;
            }
        }catch (Error e){
            System.out.println(count);
            e.printStackTrace();
        }
        //Throwable: 1.Exception,2.error
    }
}
