package com.pandy.huawei.three;

/**
 * 最长公共前缀
 */
public class A08_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String s = strs[0];
        for (String str : strs) {
            while (!str.startsWith(s)) {
                s = s.substring(0, s.length() - 1);
            }
        }
        return s;
    }
}
