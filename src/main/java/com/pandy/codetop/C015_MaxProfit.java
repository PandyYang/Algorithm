package com.pandy.codetop;

/**
 * 寻找最低，不断计算最高。
 */
public class C015_MaxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                // 寻找最低
                min = price;

                // 不断计算最高
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }
}
