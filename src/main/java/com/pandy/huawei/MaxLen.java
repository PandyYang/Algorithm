package com.pandy.huawei;

import java.util.HashSet;

public class MaxLen {

    public static int max(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int max = max("pwwkew");
        System.out.println("max = " + max);
    }
}
