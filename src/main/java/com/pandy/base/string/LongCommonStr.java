package com.pandy.base.string;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/1/25
 * 求最长的公共前缀，如果不存在公共前缀返回空字符串“”
 **/
public class LongCommonStr {

    public static String longCommonStr(String[] strs) {
        int len = strs.length;
        StringBuilder res = new StringBuilder();
        // 给字符串数组进行排序 按照升序排序 如果包含数字的时候 数字会出现在前面
        Arrays.sort(strs);

        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = LongCommonStr.longCommonStr(new String[]{"aab", "aabcc", "bcd"});
        System.out.println("s = " + s);
    }
}
