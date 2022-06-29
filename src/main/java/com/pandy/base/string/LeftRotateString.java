package com.pandy.base.string;

/**
 * @author: Pandy
 * @create: 2022/6/6
 * <p>
 * 字符序列左移
 * <p>
 * 解题思路：
 * 对于 abcXYZdef 左移 3位，可以将字符串分为两个部分：abc & XYZdef
 * 分别将两个部分进行反转得到：cba & fedZYX
 * 将两部分和在一起再进行反转：XYZdefabc
 **/
public class LeftRotateString {

    public String leftRotateString(String str, int n) {
        if (str == null || str.trim().equals("")) return str;

        String res = revert(str, 0, n - 1);
        res = revert(res, n, str.length() - 1);
        res = revert(res, 0, str.length() - 1);

        return res;
    }

    private String revert(String str, int start, int end) {
        char[] chars = str.toCharArray();

        while (start < end) {
            char t = chars[start];
            chars[start] = chars[end];
            chars[end] = t;

            start++;
            end--;
        }

        return new String(chars);
    }
}
