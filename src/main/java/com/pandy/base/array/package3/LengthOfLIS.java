package com.pandy.base.array.package3;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 最长递增子序列
 * <p>
 * 本题最关键的是要想到dp[i]由哪些状态可以推出来，并取最大值，那么很自然就能想到递推公式：dp[i] = max(dp[i], dp[j] + 1);
 **/
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {

                    // 第i个元素之前的最小上升子序列的长度无非就是max(dp[i],dp[j]+1)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
