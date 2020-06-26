package com.zcw.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @Author: AndrewBar
 * @Date: Created in 23:35 2020/6/24
 */
public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {3, 9, -1, 10, 20};

        //测试80000数据
        int[] arr = new int[80000];
        for (int i = 0; i <80000 ; i++) {
            arr[i] = (int)(Math.random() * 8000000);
        }
        //System.out.println(Arrays.toString(arr));

        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间"+date1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间"+ date2Str);
        //System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;//表示是否进行过交换
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                //如果前面数比后面数大,则交换
                if (arr[i] > arr[i + 1]) {
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            //System.out.println("第" + j + 1 + "趟排序的结果");
            //System.out.println(Arrays.toString(arr));

            if (!flag) {
                break;
            } else {
                flag = false;//重置flag进行下次判断
            }
        }
    }
    //第二趟排序
        /*for (int i = 0; i < arr.length - 1 -1; i++) {
            //如果前面数比后面数大,则交换
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第二趟排序的结果");
        System.out.println(Arrays.toString(arr));

        //第三趟排序
        for (int i = 0; i < arr.length - 1 -2; i++) {
            //如果前面数比后面数大,则交换
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第三趟排序的结果");
        System.out.println(Arrays.toString(arr));

        //第四趟排序
        for (int i = 0; i < arr.length - 1 -3; i++) {
            //如果前面数比后面数大,则交换
            if (arr[i] > arr[i+1]){
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        System.out.println("第四趟排序的结果");
        System.out.println(Arrays.toString(arr));
    }*/
}
