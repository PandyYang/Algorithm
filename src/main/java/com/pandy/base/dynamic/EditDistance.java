package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/6/28
 * <p>
 * 状态:
 * dp[i][j] 表示 word1的前i个字符匹配word2的前j个字符 变动的最少次数
 * <p>
 * DP方程:
 * DP[i][j] ----- 1. if w1[i] == w2[j]
 * dp[i-1, j-1]
 * else Min(dp[i-1,j], dp[i, j-1], dp[i-1][j-1]) + 1 // 1表示本次 insert delete replace操作
 */
public class EditDistance {


}
