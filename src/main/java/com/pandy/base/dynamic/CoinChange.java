package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/6/29
 **/
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];

        for (int k = 0; k < dp.length; k++) {
            dp[k] = max;
        }

        // 当金额为0时需要的硬币数目为0
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
