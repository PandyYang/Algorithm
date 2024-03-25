package com.pandy.codetop;

// 最长递增子序列
public class C023_LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0)
            return 0;
        // dp[i]表示当前位置的最长子序列
        int[] dp = new int[nums.length];
        // 每个元素自身就是一个最长子序列的开始
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }

        int maxLen = 1;
        for (int j = 1; j < nums.length; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }
}
