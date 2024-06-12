package com.pandy.huawei.three;

/**
 * 最长回文子串
 */
public class A04_LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        int maxLen = 0;
        String longest = "";

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= s.length(); j++) {
                String subStr = s.substring(i, i + j);
                if (isPalindrome(subStr) || subStr.length() > maxLen) {
                    maxLen = subStr.length();
                    longest = subStr;
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
