package com.pandy.base.string;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/1/25
 * 求最长的公共前缀，如果不存在公共前缀返回空字符串“”
 **/
public class LongCommonStr {

    public static String longCommonStr(String[] strs) {
        if (!checkStrs(strs)) {
            return "";
        }

        // 数组长度
        int len = strs.length;
        // 保存结果
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


    // 校验字符串数组的合法性 不能出现null或者长度为0的情况
    private static boolean checkStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
