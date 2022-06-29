package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 分割等和子集
 * <p>
 * 01 背包问题，从数组中选取元素，能否在一半数组和容量的背包中恰好放入等于一半数组和的元素
 **/
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }

        if (sum % 2 != 0) return false;

        int max = sum / 2;

        int[] dp = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = max; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        return dp[max] == max;
    }
}
