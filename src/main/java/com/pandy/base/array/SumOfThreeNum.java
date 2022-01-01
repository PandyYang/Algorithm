package com.pandy.base.array;

import java.util.*;

/**
 * @author: Pandy
 * @create: 2022/1/1
 * 三数之和为0
 **/
public class SumOfThreeNum {
    public List<List<Integer>> sum(int[] arr) {

        Arrays.sort(arr);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) break;
            int target = -arr[i];
            int left = i + 1;
            int right = arr.length-1;
            while (left < right) {
                if (target < arr[left] + arr[right]){
                    right--;
                } else if (target > arr[left] + arr[right]) {
                    left ++;
                } else {
                    set.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
