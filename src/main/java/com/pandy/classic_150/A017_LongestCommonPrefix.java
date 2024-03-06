package com.pandy.classic_150;

public class A017_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String commonStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            commonStr = getCommonPrefix(commonStr, strs[i]);
            if (commonStr.equals("")) {
                return "";
            }
        }
        return commonStr;
    }

    // 获取公共长度
    private String getCommonPrefix(String str1, String str2) {
        int index = 0;
        while (index < str1.length() && index < str2.length() && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }
}
