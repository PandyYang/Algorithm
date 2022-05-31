package com.pandy.base.string;

import java.util.HashMap;

/**
 * @author: Pandy
 * @create: 2022/3/29
 * 
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 
 * abcabcbb，当i等于3时，也就是指向了第二个a, 此时我就需要查之前有没有出现过a,
 * 如果出现了是在哪一个位置出现的。然后通过last[index] 查到等于1, 也就是说，
 * 如果start 依然等于0的话，那么当前窗口就有两个a了，也就是字符串重复了，
 * 所以我们需要移动当前窗口的start指针，移动到什么地方呢？移动到什么地方，窗口内就没有重复元素了呢？
 * 对了，就是a上一次出现的位置的下一个位置，就是1 + 1 = 2。当start == 2, 当前窗口就没有了重复元素，
 * 那么以当前字符为结尾的最长无重复子串就是bca,然后再和之前的res取最大值。然后i指向后面的位置，按照同样思路计算。
 **/
public class LengthOfLongestSubstring {
    public static int length(String s) {
        int[] last = new int[128];
        int n = s.length();

        int res = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            // start为0代表出现过元素
            start = Math.max(start, last[index] + 1);
            // 当前出现的最大无重复位置
            res = Math.max(res, i - start + 1);

            // last[index] 是第一次出现位置
            last[index] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int abcabcbb = length("aab");
        System.out.println("abcabcbb = " + abcabcbb);
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {
                start = Math.max(map.get(ch) + 1, start);
            }
            max = Math.max(max, end - start + 1);
            map.put(ch, end);
        }
        return max;
    }
}
