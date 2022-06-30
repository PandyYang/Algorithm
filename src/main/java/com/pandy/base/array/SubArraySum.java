package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 和为k的子数组
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 **/
public class SubArraySum {

    public int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int end = i; end >= 0; end--) {

                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
