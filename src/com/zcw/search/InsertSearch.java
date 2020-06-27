package com.zcw.search;

/**
 * @Author: AndrewBar
 * @Date: Created in 0:50 2020/6/27
 */
public class InsertSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i+1;
        }
        int index = insertSearch(arr,0,arr.length-1,86);
        System.out.println(index);
    }
    //插值查找,找mid方式变为自适应
    public static int insertSearch(int[] arr,int left,int right,int value){
        if (left > right || value < arr[0] || value >arr.length - 1){
            return -1;
        }
        //求mid
        int mid = left + (right - left)*(value - arr[left]) / (arr[right] - arr[left]);
        int midval = arr[mid];
        if (value > midval){//向右递归
            return insertSearch(arr,mid +1 ,right,value);
        }else if (value < midval){
            return insertSearch(arr,left,mid - 1,value);
        } else{
            return mid;
        }
    }
}
