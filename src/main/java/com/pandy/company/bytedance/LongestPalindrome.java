package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/2
 **/
public class LongestPalindrome {

    public String longest(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示s[i..j]是否是回文串
        boolean[][] dp = new boolean[len][len];

        // 初始化: 所有长度为1的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++) {
                // j - i + 1 = L
                int j = L + i - 1;
                if (j >= len) break;
                if (charArray[i] != charArray[j]) {
                    dp[i][j] =false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i +1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
