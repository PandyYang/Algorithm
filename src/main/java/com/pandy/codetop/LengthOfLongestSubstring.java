package com.pandy.codetop;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    // 最长无重复的子串
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int start = 0;
        int maxLength = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            // 每个元素最开始的位置
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.put(s.charAt(i), i) + 1, start);
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int[] hash = new int[128];
        int length = 0, prev = 0, i = 0;
        for (char c : s.toCharArray()) {
            prev = Math.max(prev, hash[c]);
            hash[c] = ++i;
            length = Math.max(length, hash[c] - prev);
        }
        return length;
    }

    public static void main(String[] args) {
        int pwwkew = LengthOfLongestSubstring.lengthOfLongestSubstring2("abcabcbb");
        System.out.println("pwwkew = " + pwwkew);
    }
}
