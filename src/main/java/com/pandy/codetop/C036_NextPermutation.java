package com.pandy.codetop;

import java.util.Arrays;

public class C036_NextPermutation {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            // 顺向排序的 下一个逆位
            // 1 2 3
            // 3 > 2
            if (nums[i] > nums[i-1]) {
                // 1 2 3
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    // 3 > 2
                    if (nums[j] > nums[i-1]) {
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;   // 1 3 2
                        return;
                    }
                }
            }
        }
        // 已经是 最大排列 转为最小
        Arrays.sort(nums);
    }
}
