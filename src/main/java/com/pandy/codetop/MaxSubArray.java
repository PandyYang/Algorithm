package com.pandy.codetop;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // 有增益 则可以继续增加元素
            if (sum > 0) {
                sum += nums[i];
            } else {
                // 没有增益 则将其置为当前值
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

}
