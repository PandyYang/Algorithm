package com.pandy.company.bytedance;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 使数组唯一的最小增量
 **/
public class MinIncrementForUnique {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int move = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i-1]) {
                int pre = nums[i];
                nums[i] = nums[i-1] + 1;
                move += nums[i] - pre;
            }
        }
        return move;
    }
}
