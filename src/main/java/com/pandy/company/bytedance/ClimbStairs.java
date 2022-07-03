package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 爬楼梯
 **/
public class ClimbStairs {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = r;
            r = q + q;
        }
        return r;
    }

    public int climb(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
