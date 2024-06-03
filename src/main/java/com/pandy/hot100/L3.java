package com.pandy.hot100;

import java.util.HashSet;

public class L3 {
    public int lengthOfLongestSubstring(String s) {

        int max = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = k; j < i; j++) {
                // 找到一个不重复子串
                if (s.charAt(j) == s.charAt(i)) {
                    k = j + 1;
                    break;
                }
            }
            // 收集子串
            max = Math.max(max, i - k +1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int i = 0, j = 0, max = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(max, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        L3 l3 = new L3();
        int i = l3.lengthOfLongestSubstring("abcabca");
        System.out.println("i = " + i);
    }
}
