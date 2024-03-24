package com.pandy.codetop;

import java.util.HashMap;

public class C001_LengthOfLongestSubstring {

    // 最长无重复的子串
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                // 计算上一次的i和当前的坐标，最大的那一个
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            // 记录元素及其对应的坐标
            dic.put(s.charAt(j), j);
            // 计算最大结果
            res= Math.max(res, j - i);
        }
        return res;
    }


    public static void main(String[] args) {
        int pwwkew = C001_LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println("pwwkew = " + pwwkew);
    }
}
