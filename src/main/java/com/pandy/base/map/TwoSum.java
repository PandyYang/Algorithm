package com.pandy.base.map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/1/2
 * 两数之和
 * 使用map存储坐标
 **/
public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int res = target - arr[i];
            if (map.containsKey(res)) {
                return new int[]{map.get(res), i};
            } else {
                map.put(arr[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ints = twoSum(arr, 9);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
