package com.zcw.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: AndrewBar
 * @Date: Created in 0:14 2020/6/27
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1000,1000,1000,1234};
        int resIndex = binarySearch(arr,0,arr.length-1,9);
        System.out.println(resIndex);

        ArrayList<Integer> arrayList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(arrayList);
    }
    //二分查找,数组有序

    /**
     *
     * @param arr 数组
     * @param left 左边索引
     * @param right 右边索引
     * @param value 查找值
     * @return 找到返回下标,没找到返回-1
     */
    public static int binarySearch(int[] arr,int left,int right,int value){
        if (left > right){
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value > midVal){//需查找值大于中间值,向右递归
            return  binarySearch(arr,mid +1,right,value);
        }else if (value < midVal){
            return binarySearch(arr,0,mid -1,value);
        }else{
            //找到mid值时,不要马上返回,向mid值左边查找,相应值加入ArrayList
            return mid;
        }
    }

    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int value){
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (value > midVal){//需查找值大于中间值,向右递归
            return  binarySearch2(arr,mid +1,right,value);
        }else if (value < midVal){
            return binarySearch2(arr,0,mid -1,value);
        }else{
            //找到mid值时,不要马上返回,向mid值左边查找,相应值加入ArrayList
            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            int temp = mid -1;
            while(true){
                if (temp < 0 || arr[temp] != value){//因为是有序的,发现不等于value,就可以退出
                    break;
                }
                //否则将temp放入resIndexList
                resIndexList.add(temp);
                temp -=1;//temp左移
            }
            resIndexList.add(mid);

            temp = mid +1;
            while(true){
                if (temp > arr.length-1 || arr[temp] != value){//因为是有序的,发现不等于value,就可以退出
                    break;
                }
                //否则将temp放入resIndexList
                resIndexList.add(temp);
                temp +=1;//temp左移
            }
            return resIndexList;
        }
    }
}
