package com.zcw.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:44 2020/6/25
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        int[] arr2 = new int[100000];
//        for (int i = 0; i <100000 ; i++) {
//            arr[i] = (int)(Math.random() * 8000000);
//        }
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间"+date1Str);

        shellSort2(arr);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间"+ date2Str);

    }

    //希尔排序,交换法
    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length /2; gap > 0; gap /=2) {//开始步长,和进入下一次循环的新步长
            for (int i = gap; i < arr.length; i++) {
                //遍历各组中所有的元素(共5组,每组有2个元素),步长5
                for (int j = i - gap; j >= 0; j -= gap) {
                    //如果当前元素大于加上步长后的那个元素,说明交换
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
    }
    //移位法,,多次分组排序
    public static void shellSort2(int[] arr){
        for (int gap = arr.length /2; gap > 0; gap /=2){
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while(j - gap >=0 && temp < arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //档推出while后,就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }
    }
}
