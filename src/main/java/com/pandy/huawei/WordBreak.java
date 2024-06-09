package com.pandy.huawei;

import java.util.*;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("leet");
        strings.add("code");
        strings.add("abc");
        boolean leetcode = wordBreak("leetcode", strings);
        System.out.println("leetcode = " + leetcode);
    }
}
