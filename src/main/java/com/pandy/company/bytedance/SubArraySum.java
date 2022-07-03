package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 和为k的子数组
 **/
public class SubArraySum {
    int count = 0;
    public int subArraySum(int[] nums, int k) {
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }
}
