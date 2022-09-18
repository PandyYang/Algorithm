package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * 买卖股票
 **/
public class MaxProfit {

    /**
     * 遍历一次记录历史最低点，然后每天想一个问题：如果我是在历史最低点买进的，
     * 那我今天卖出，最多能赚多少钱。
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    /**
     * 暴力法 记录每个间隔 然后对比
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(profit, maxProfit);
            }
        }
        return maxProfit;
    }
}
