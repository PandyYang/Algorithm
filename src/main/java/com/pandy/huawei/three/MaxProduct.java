package com.pandy.huawei.three;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaxProduct {
    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (isCommon(words[i], words[j])) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }

    public boolean isCommon(String a1, String a2) {
        Set<Character> set = new HashSet<>();
        for (char c : a1.toCharArray()) {
            set.add(c);
        }

        for (char c : a2.toCharArray()) {
            if (set.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = new MaxProduct().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
        System.out.println("i = " + i);
    }
}
