package com.pandy.base.string;

import java.util.HashMap;

/**
 * @author: Pandy
 * @create: 2022/3/29
 *
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, start = 0;
        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (map.containsKey(ch)) {

                // 已存在元素 更新start
                start = Math.max(map.get(ch) + 1, start);
            }
            // 每次将当前位置 和未重复位置 计算一下
            max = Math.max(max, end - start + 1);
            // 记录元素及其索引
            map.put(ch, end);
        }
        return max;
    }
}
