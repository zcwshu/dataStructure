package com.zcw.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author: AndrewBar
 * @Date: Created in 20:39 2020/7/22
 */
public class Test6 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Hashtable<Integer, Integer> hashTable = new Hashtable<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            hashTable.put(arr[i],i);
        }
        Arrays.sort(arr);
        int count = 1;
        for (int i = arr.length-1; i > 0; i++) {

        }
    }
}
