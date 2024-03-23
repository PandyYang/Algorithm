package com.pandy.codetop;

public class C011_LongestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subStr = s.substring(i, j);
                if (isPalindrome(subStr) && subStr.length() > longest.length()) {
                    longest = subStr;
                }
            }
        }
        return longest;
    }

    public String longestPalindromeDP(String s) {
        // 存储字符串s中子串是否为回文子串的状态，dp[i][j]表示从索引i到j的子串是否为回文子串
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int[] max = new int[2];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                // 如果子串长度为2且首尾字符相等，则该子串为回文子串。
                if (i-j == 1 && chars[i]==chars[j]) {
                    dp[j][i] = true;
                    // 如果去除首尾字符后的子串为回文子串，并且首尾字符相等，则该子串也为回文子串。
                } else if (dp[j+1][i-1]==true && chars[i]==chars[j]) {
                    dp[j][i] = true;
                }
                // 如果当前子串为回文子串且长度大于已知的最长回文子串，则更新最长回文子串的起始索引和结束索引。
                if (dp[j][i]==true && max[1] - max[0] < i -j) {
                    max[0] = j;
                    max[1] = i;
                }
            }
        }
            return s.substring(max[0], max[1] +1);
    }

    public String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLen = 1;

        //遍历字符串 s 中的每一个字符，将对角线上的元素均设为 true，因为单个字符一定是回文子串。
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // j是回文字符串的结束为止
        for (int j = 1; j < n; j++) {
            // 内层循环遍历从字符串起始位置到当前字符的所有可能的起始位置。
            for (int i = 0; i < j; i++) {
                // 如果首尾字符相等，并且去除首尾字符后的子串为回文子串，则将当前子串设为回文子串。
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1])) {
                    // 表示从索引 i 到索引 j 的子串为回文子串。
                    dp[i][j] = true;
                    // 更新最长回文子串的长度 maxLen 和起始索引 start。
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        C011_LongestPalindrome c011LongestPalindrome = new C011_LongestPalindrome();
        String babad = c011LongestPalindrome.longestPalindrome2("babad");
        System.out.println("babad = " + babad);
    }
}
