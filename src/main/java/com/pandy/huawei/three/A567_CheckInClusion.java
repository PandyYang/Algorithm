package com.pandy.huawei.three;

import java.util.Arrays;

public class A567_CheckInClusion {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        // 计算 s1 的字符频次
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // 滑动窗口比较
        for (int i = len1; i < len2; i++) {
            if (Arrays.equals(count1, count2)) {
                return true;
            }
            // 移动窗口
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - len1) - 'a']--;
        }

        // 最后一次比较
        return Arrays.equals(count1, count2);
    }

    public static void main(String[] args) {
        boolean b = new A567_CheckInClusion().checkInclusion("ab", "eidbaooo");
        System.out.println("b = " + b);
    }
}
