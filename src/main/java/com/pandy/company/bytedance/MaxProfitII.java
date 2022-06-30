package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/6/30
 **/
public class MaxProfitII {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; i++) {
            ans  += Math.max(0, prices[i] - prices[i-1]);
        }
        return ans;
    }
}
