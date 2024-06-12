package com.pandy.huawei.three;

/**
 * 我们可以用一个数组 dp 来存储到达每一阶的方法数，dp[i] 表示到达第 i 阶的方法数。初始条件是：
 *
 * dp[0] = 1（虽然不存在第0阶，但为了使递推公式成立，可以认为到达0阶有1种方法，即不动。）
 * dp[1] = 1（到达第1阶只有一种方法，即爬1阶。）
 */
public class A70_ClimbStairs {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
