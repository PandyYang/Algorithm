package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/6/29
 **/
public class NumSquares {

    // 先遍历物品 再遍历背包
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n+1];

        // 初始化
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }

        // 当和为0时 组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i*i <= n; i++) {
            // 遍历背包
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i] != max) {
                    dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
                }
            }
        }
        return dp[n];
    }

    /**
     * 我们可以依据题目的要求写出状态表达式：f[i]f[i] 表示最少需要多少个数的平方来表示整数 ii。
     *
     * 这些数必然落在区间 [1,\sqrt{n}][1,
     * n
     * 
     *  ]。我们可以枚举这些数，假设当前枚举到 jj，那么我们还需要取若干数的平方，构成 i-j^2i−j
     * 2
     *  。此时我们发现该子问题和原问题类似，只是规模变小了。这符合了动态规划的要求，于是我们可以写出状态转移方程。
     *
     * f[i]=1+\min_{j=1}^{\lfloor\sqrt{i}\rfloor}{f[i-j^2]}
     * f[i]=1+
     * j=1
     * min
     * ⌊
     * i
     * 
     *  ⌋
     * 
     *  f[i−j
     * 2
     *  ]
     *
     * 其中 f[0]=0f[0]=0 为边界条件，实际上我们无法表示数字 00，只是为了保证状态转移过程中遇到 jj 恰为 \sqrt{i}
     * i
     * 
     *   的情况合法。
     *
     * 同时因为计算 f[i]f[i] 时所需要用到的状态仅有 f[i-j^2]f[i−j
     * 2
     *  ]，必然小于 ii，因此我们只需要从小到大地枚举 ii 来计算 f[i]f[i] 即可。
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int[] f = new int[n+1];
        for (int i = 1; i <= n; i++) {
            int minn = Integer.MAX_VALUE;
            for (int j = 1; j*j <= i; j++) {
                minn = Math.min(minn, f[i-j*j]);
            }
            f[i] = minn +1;
        }
        return f[n];
    }
}
