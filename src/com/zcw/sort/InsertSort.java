package com.zcw.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: AndrewBar
 * @Date: Created in 17:22 2020/6/25
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr2 = {64,101,37,34,119,21,85,1};
//        int[] arr = new int[100000];
//        for (int i = 0; i <100000 ; i++) {
//            arr[i] = (int)(Math.random() * 8000000);
//        }
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间"+date1Str);

        insertSort(arr2);
        System.out.println(Arrays.toString(arr2));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间"+ date2Str);
    }

    //插入排序,第一个数作为有序序列,剩余数作为无序序列,往有序中插入
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //定义待插入数
            int insertVal = arr[i];
            int insertIndex = i -1;
            //给insertVal找到位置
            //insertIndex >= 0,保证在给insertVal 找插入位置不越界
            //insertVal < arr[insertIndex ]待插入的数,还没找到适当的位置
            //就需要将iarr[insertIndex]后移
            while(insertIndex >= 0 && insertVal < arr[insertIndex ]){
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;//与前一个数比较
            }
            //当退出while循环时,说明插入的位置找到,insertIndex + 1
            //优化:判断是否需要赋值
            if (insertIndex != i){
                arr[insertIndex + 1] = insertVal;
            }
        }
    }
}
