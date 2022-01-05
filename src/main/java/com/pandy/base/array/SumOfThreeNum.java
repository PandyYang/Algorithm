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
        // 使用set进行天然去重
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // 排序之后第一个数字大于0 则不可能有三数之和大于0
            if (arr[i] > 0) break;
            // 将target作为arr[i] 则x + y = arr[i] 符合条件
            // arr[i] = -target
            // x + y + target = 0
            // 此时的x y i 满足条件
            int target = -arr[i];
            // 此时的   i i+1 arr.length - 1
            // 这三个位置分别对应 0 1 最后
            int left = i + 1;

            int right = arr.length-1;

            // while循环中使用双指针 找到符合条件的值
            while (left < right) {
                if (target < arr[left] + arr[right]){
                    right--;
                } else if (target > arr[left] + arr[right]) {
                    left ++;
                } else {
                    // 找到值 存入
                    //  继续加left
                    set.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}
