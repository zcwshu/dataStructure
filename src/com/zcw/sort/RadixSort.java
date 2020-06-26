package com.zcw.sort;

import java.util.Arrays;

/**
 * @Author: AndrewBar
 * @Date: Created in 17:53 2020/6/26
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53,3,542,748,14,214};
        rdixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //基数排序,个十百...位依次比较大小,每次比较完,化为一个数组,再次比较
    //稳定的排序,但是会消耗内存空间
    public static void rdixSort(int[] arr){
        //得到数组中最大数的位数
        int max = arr[0];//假设第一个数最大
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();
        //int maxLength = Integer.toString(max);
        //定义一个二维数组,表示10个桶,每个桶是一个一维数组
        //每个一维数组大小arr.length,空间换时间
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中实际存放数据量,我们定义一个一维数组来记录各个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素的各位
                int digitOfElement = arr[j] /n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            //把桶中数取出放回原数组
            int index = 0;
            //遍历每一个桶,并将桶中的数据,放回原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据,放回原数组
                if (bucketElementCounts[k] != 0){
                    //循环该桶(即第k个一维数组)
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                //需要将bucketElementCounts[k]置0
                bucketElementCounts[k] = 0;
            }
        }
    }
}
