package com.zcw.search;

/**
 * @Author: AndrewBar
 * @Date: Created in 14:24 2020/8/1
 */
public class BinarySearch2 {
    public static void main(String[] args) {
        int [] arr={5,13,19,21,37,56,64,75,80,88,92};    //数组必须是有序的

        int low = 0;    //低位
        int high = arr.length;    //高位
        int mid = 0;    //可以随便给中位赋值下标

        int find = 37;    //查找值

        boolean flag = false;

        while(low <= high){        //只要高位边不比低位小，就继续二分
            mid = (low + high)/2;    //二分后有三种情况：中位比find值大；中位比find值小；中位和find值相等

            if(arr[mid] > find){    //二分之后中位比find值大，说明find值在中位的右边，那么高位就是此时的中位，然后继续二分
                high = mid - 1;
            }else if(arr[mid] < find){    //二分后中位比find值小，说明find值在中位的左边，那么低位就是此时的中位，然后继续二分
                low = mid + 1;
            }else{                        //当中位和find值相等时，找到find值所对应的下标，二分结束
                flag = true;
                System.out.println(mid);
                break;
            }
        }
        if(flag){
            System.out.println("mid=" + mid +"========"+ "find="+ arr[mid]);
        }else{
            System.out.println(-low - 1);    //如果没找到，那肯定是低位大于了高位，且低位和高位相挨着，返回没有找到的find值应该所在的下标位置（即-low - 1）
        }
    }
}
