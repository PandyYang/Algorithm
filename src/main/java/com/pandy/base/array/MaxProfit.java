package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/6/29
 *
 * 给定一个整数数组prices，其中第prices[i]表示第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * 两个状态，0 ： 未持有，1 ：持有
 **/
public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        dp[1][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i+1][0] = Math.max(dp[i][1] + prices[i], dp[i][0]);
            dp[i+1][1] = Math.max(dp[i-1][0] - prices[i], dp[i][1]);
        }
        return dp[prices.length][0];
    }
}
