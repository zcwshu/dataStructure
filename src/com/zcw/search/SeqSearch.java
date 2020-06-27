package com.zcw.search;

/**
 * @Author: AndrewBar
 * @Date: Created in 0:01 2020/6/27
 */
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr = {1,9,11,0,-1,34,89};
        int index = seqSearch(arr,11);
        if (index == -1){
            System.out.println("没有找到");
        }else{
            System.out.println("i");
        }
    }
    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }
        }
        return -1;
    }
}
