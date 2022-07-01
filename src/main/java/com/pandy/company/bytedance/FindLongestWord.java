package com.pandy.company.bytedance;

import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字母序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 **/
public class FindLongestWord {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String t : dictionary) {

            // 字符匹配
            int i = 0, j = 0;
            while (i < t.length() && j < s.length()) {
                if (t.charAt(i) == s.charAt(j)) {
                    i++;
                }
                j++;
            }

            // 匹配到了t中的元素
            if (i == t.length()) {
                // 找出大的情况
                if (t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)) {
                    // 收集最长的字符串 t中的元素
                    res = t;
                }
            }
        }
        return res;
    }
}
