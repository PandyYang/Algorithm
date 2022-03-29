package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/3/29
 **/
public class TranslateNum {

    public int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < str.length(); i++) {
            String tmpStr = str.substring(i - 2, i);
            if (tmpStr.compareTo("10") >= 0 && tmpStr.compareTo("25") <= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length - 1];
    }

    public int translateNum2(int num) {
        if (num < 9) return 1;
        int ba = num % 100;
        if (ba <= 9 || ba >= 26) {
            return translateNum2(num / 10);
        } else {
            return translateNum2(num/10) + translateNum2(num/100);
        }
    }
}
