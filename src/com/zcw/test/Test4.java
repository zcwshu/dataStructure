package com.zcw.test;
import java.util.*;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] arr = input.split(" ");

        System.out.println(getnum(arr));
    }

    public static int getnum(String[] arr) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                Integer o = (Integer) map.get(arr[i]);
                map.put(arr[i], o + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int count = 0;
        int max = 0;
        for (Integer i : map.values()) {
            if (i >= 2) {
                count++;
            }
            if (max < i) {
                max = i;
            }
        }
        if (count < 2 && max <4) {
            return -1;
        }

        Set<String> strings = map.keySet();
        Set<String> tmp = new HashSet<>();
        for (String string : strings) {
            if (map.get(string) < 2){
                tmp.add(string);
            }
        }

        for (String s : tmp) {
            strings.remove(s);
        }

        Object[] objects = strings.toArray();

        Arrays.sort(objects);

        if (map.get(objects[objects.length - 1]) >= 4) {
            return Integer.parseInt(objects[objects.length - 1].toString()) * Integer.parseInt(objects[objects.length - 1].toString());
        } else {
            return Integer.parseInt(objects[objects.length - 1].toString()) * Integer.parseInt(objects[objects.length - 2].toString());
        }
    }
}


