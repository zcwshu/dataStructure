package com.zcw.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: AndrewBar
 * @Date: Created in 11:46 2020/6/25
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
        /*int[] arr = new int[100000];
        for (int i = 0; i <100000 ; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间"+date1Str);

        selectSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间"+ date2Str);*/
    }

    //选择排序,每次选出最小的数,放到数组 前面+1 位置
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;//最小数的索引
            int min = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (min > arr[j]){
                    min = arr[j];
                    // 记录目前能找到的最小值元素的下标
                    minIndex = j;
                }
            }
            //将找到的最小值和i位置所在的值进行交换
            if (minIndex != i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
}
