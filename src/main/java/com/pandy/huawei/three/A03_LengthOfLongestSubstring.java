package com.pandy.huawei.three;

import java.util.HashSet;

public class A03_LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int left = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // 如果集合中已经包含当前字符，移动left指针直到集合中不再有重复字符
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new A03_LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb");
        System.out.println("i = " + i);
    }
}
