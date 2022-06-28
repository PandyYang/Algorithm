package com.pandy.base.array.package02;

/**
 * @author: Pandy
 * @create: 2022/1/3
 *
 * 股票的最大利润
 *
 * 重点的步骤有两个，
 **/
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            // 取最左最小价格
            low = Math.min(low, prices[i]);
            // 直接取最大区间利润
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
}
