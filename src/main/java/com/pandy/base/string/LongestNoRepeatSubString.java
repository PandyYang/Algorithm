package com.pandy.base.string;

import java.util.HashMap;

/**
 * @author: Pandy
 * @create: 2022/1/15
 * 给定一个字符串 请你找出其中不含有重复字符的最长子串的长度
 *
 * 用 Map 记录字符所在位置，当遇到重复字符时，移动 start 指针
 * 替换 Map 中下标，并计算子串长度
 *
 *
 *
 *
 *
 *
 * 用一个 hashmap 来建立字符和其出现位置之间的映射。同时维护一个滑动窗口，窗口内的都是没有重复的字符，去尽可能的扩大窗口的大小，窗口不停的向右滑动。
 * 如果当前遍历到的字符从未出现过，那么直接扩大右边界；
 * 如果当前遍历到的字符出现过，则缩小窗口（左边索引向右移动），然后继续观察当前遍历到的字符；
 * 重复（1）（2），直到窗口内无重复元素；
 * 维护一个全局最大窗口 res，每次用出现过的窗口大小来更新结果 res，最后返回 res 获取结果;
 * 最后返回 res 即可;
 **/
public class LongestNoRepeatSubString {
    public int longestNoRepeatSubString(String str) {
        if (str == null || str.length() == 0) return 0;

        HashMap<Character, Integer> temp = new HashMap<>();
        char[] chars = str.toCharArray();

        int res = 0, start = 0;
        for (int i = 0; i < chars.length; i++) {
            // 有重复数字 窗口 右滑
            if (temp.containsKey(chars[i])) {

                // 左边界的最大值
                start = Math.max(temp.put(chars[i], i) + 1, start);
            }

            temp.put(chars[i], i);
            res = Math.max(res, i - start + 1);
        }

        return res;
    }

}
