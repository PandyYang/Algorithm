package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 **/
public class CountSubString {
    int num = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            count(s, i, i);//回文串长度为奇数
            count(s, i, i + 1);//回文串长度为偶数
        }
        return num;
    }

    public void count(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            num++;
            start--;
            end++;
        }
    }

}
