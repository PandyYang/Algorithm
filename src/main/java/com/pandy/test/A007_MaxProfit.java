package com.pandy.test;

public class A007_MaxProfit {
    public int maxProfit(int[] prices) {
        // 最大最小
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            // 找出最低价格
            if (min > prices[i]) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}
