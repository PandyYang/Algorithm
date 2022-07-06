package com.pandy.base.dynamic;

/**
 * @author Pandy
 * @date 6/7/2022
 *
 * 正则表达式匹配
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        boolean[][] dp = new boolean[cs.length+1][cp.length+1];

        // s为空 p为空 可以匹配上
        dp[0][0] = true;

        // s为空 p不为空 由于*可以匹配0个字符 所以有可能为true
        for (int i = 1; i <= cp.length; i++) {
            if (cp[i - 1] == '*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        // 填格子
        for (int i = 1; i <= cs.length; i++) {
            for (int j = 1; j <= cp.length; j++) {
                // 文本串和模式串末位字符能匹配上
                if (cs[i-1] == cp[j-1] || cp[j-1] == '.') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (cp[j-1] == '*') { //模式串末尾是*
                    if (cs[i-1] == cp[j-2] || cp[j-2] == '.') {
                        dp[i][j] = dp[i][j-2]  // * 匹配0次的情况
                                || dp[i-1][j]; // * 匹配一次或多次的情况
                    } else {
                        // 模式串的前一个字符不能跟文本串的末位匹配
                        dp[i][j] = dp[i][j-2]; // *只能匹配0次
                    }

                }
            }
        }
        return dp[cs.length][cp.length];
    }
}
