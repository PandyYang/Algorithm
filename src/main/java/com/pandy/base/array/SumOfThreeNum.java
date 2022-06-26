package com.pandy.base.array;

import java.util.*;

/**
 * @author: Pandy
 * @create: 2022/1/1
 * 三数之和为0
 * 
 * 
 * 
 * 采用分治的思想找出三个数相加等于 0，我们可以数组依次遍历，
 * 每一项 a[i]我们都认为它是最终能够用组成 0 中的一个数字，
 * 那么我们的目标就是找到剩下的元素（除 a[i]）两个相加等于-a[i].
 **/
public class SumOfThreeNum {
    public List<List<Integer>> sum(int[] arr) {
        Arrays.sort(arr);
        // 使用set进行天然去重
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            // 排序之后第一个数字大于0 则不可能有三数之和大于0
            if (arr[i] > 0) break;

            int target = -arr[i];
            // 此时的   i i+1 arr.length - 1
            // 这三个位置分别对应 0 1 最后
            int left = i + 1;

            int right = arr.length - 1;

            // while循环中使用双指针 找到符合条件的值
            while (left < right) {
                if (target < arr[left] + arr[right]) {
                    right--;
                } else if (target > arr[left] + arr[right]) {
                    left++;
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
