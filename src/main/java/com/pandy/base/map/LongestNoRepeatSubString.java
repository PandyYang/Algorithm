package com.pandy.base.map;

import java.util.HashMap;

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
        if (str == null || str.length() == 0) return 0;

        HashMap<Character, Integer> temp = new HashMap<>();
        char[] chars = str.toCharArray();

        int res = 0, start = 0;

        for (int i = 0; i < chars.length; i++) {
            if (temp.containsKey(chars[i])) {
                start = Math.max(temp.put(chars[i], i) + 1, start);
            }
            temp.put(chars[i], i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
