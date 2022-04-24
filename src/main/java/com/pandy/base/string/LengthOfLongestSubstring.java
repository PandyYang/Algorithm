package com.pandy.base.string;

import javafx.beans.binding.ObjectExpression;

import java.util.*;

/**
 * @author: Pandy
 * @create: 2022/3/29
 *
 * 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class LengthOfLongestSubstring {
    public static int length(String s) {
        if (Objects.equals(s, "")) return 0;
        if (s.length() == 1) return 1;
        int length = Integer.MIN_VALUE;
        List<Character> list = new LinkedList<>();
        char[] chars = s.toCharArray();
        list.add(s.charAt(0));
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (list.contains(chars[j])) {
                    i = j;
                    length = Math.max(length, list.size());
                    list.remove(i);
                } else {
                    list.add(chars[j]);
                }
                length = Math.max(length, list.size());
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int abcabcbb = length("aab");
        System.out.println("abcabcbb = " + abcabcbb);
    }
}
