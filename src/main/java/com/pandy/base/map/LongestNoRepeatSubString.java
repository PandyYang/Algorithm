package com.pandy.base.map;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: Pandy
 * @create: 2022/6/6
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 * <p>
 * 用 Map 记录字符所在位置，当遇到重复字符时，移动 start 指针
 * 替换 Map 中下标，并计算子串长度
 **/
public class LongestNoRepeatSubString {

    public int longest(String str) {
        int n = str.length();
        HashSet<Character> set = new HashSet<>();

        int maxLen = 0;
        int left = 0, right = 0;

        while (right < n) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(str.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
