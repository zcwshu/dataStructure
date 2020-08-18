package com.zcw.tree;

/**
 * @Author: AndrewBar
 * @Date: Created in 9:26 2020/7/28
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
    }
    public static void heapSort(int[] arr){
        System.out.println("堆排序!");
    }

    //将数组(二叉树),调整成一个大顶堆

    /**
     *功能:完成将以i对应的非叶子节点调整成大顶堆
     * @param arr 待调整数组
     * @param i 表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素继续调整,length在逐渐减少
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];

    }
}
