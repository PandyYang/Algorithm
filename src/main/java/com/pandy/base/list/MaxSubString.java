package com.pandy.base.list;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Pandy
 * @date 31/12/2021
 * 无重复字符的最长子串 使用滑动窗口求解
 * <p>
 * 使用set进行滑动窗口
 * 使用两个指针
 * 滑动窗口都使用双指针解决，并且记录最长长度
 */
public class MaxSubString {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0;
        int i = 0, j = 0;
        int len = s.length();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
