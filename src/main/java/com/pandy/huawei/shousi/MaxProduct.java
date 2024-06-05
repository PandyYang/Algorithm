package com.pandy.huawei.shousi;

import java.util.*;

public class MaxProduct {
    public int max(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (int i = words.length - 1; i >= 1; i--) {
            int j = i - 1;
            if (isCommon(words[i], words[j])) {
                return words[i].length() * words[j].length();
            }
        }
        return 0;
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
        MaxProduct maxProduct = new MaxProduct();
        int max = maxProduct.max(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"});
        System.out.println("max = " + max);
    }
}
