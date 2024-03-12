package com.pandy.classic_150;

/**
 * 给你两个字符串 haystack 和 needle ，
 * 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回  -1 。
 */
public class A022_StrStr {

    public static int strStr(String haystack, String needle) {

        if (needle.isEmpty()) {
            return 0; // 如果 needle 为空，则直接返回 0
        }

        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i <= m - n; i++) {
            int j;
            for (j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break; // 如果当前字符不匹配，则跳出内层循环
                }
            }
            if (j == n) {
                return i; // 如果内层循环结束时 j 等于 n，说明匹配成功，返回当前下标
            }
        }

        return -1; // 如果未找到匹配项，则返回 -1
    }

    public static void main(String[] args) {
        int i = A022_StrStr.strStr("abcdef", "de");
        System.out.println("i = " + i);
    }
}
