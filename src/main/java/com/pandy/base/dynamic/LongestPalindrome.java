package com.pandy.base.dynamic;

/**
 * @author Pandy
 * @date 24/3/2022
 */
public class LongestPalindrome {


    // 动态规划求解
    public static String getLPS(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;

        boolean[][] lps = new boolean[length][length];

        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 2) {
                    lps[j][i] = chars[i] == chars[j];
                } else {
                    lps[j][i] = lps[j+1][i-1] && (chars[i] == chars[j]);
                }

                if (lps[j][i] && i-j+1 > maxLen) {
                    maxLen = i - j + 1;
                    start = j;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
