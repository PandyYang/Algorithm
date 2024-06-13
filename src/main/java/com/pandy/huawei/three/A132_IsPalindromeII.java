package com.pandy.huawei.three;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
 * 回文串
 * 。
 * <p>
 * 返回符合要求的 最少分割次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：1
 * 解释：只需一次分割就可将 s 分割成 ["aa","b"] 这样两个回文子串。
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：s = "ab"
 * 输出：1
 */
public class A132_IsPalindromeII {
    public int minCut(String s) {
        return minCutHelper(s, 0);
    }

    private int minCutHelper(String s, int start) {

        if (start == s.length() - 1) {
            return -1;
        }

        int minCuts = Integer.MAX_VALUE;
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                minCuts = Math.min(minCuts, 1 + minCutHelper(s, end + 1));
            }
        }
        return minCuts;
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
