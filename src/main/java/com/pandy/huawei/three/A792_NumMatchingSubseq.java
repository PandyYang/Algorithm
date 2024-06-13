package com.pandy.huawei.three;

import java.util.HashMap;
import java.util.Map;

public class A792_NumMatchingSubseq {
    public int numMatchingSubseq(String s, String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        int count = 0;
        for (String word : words) {
            if (map.containsKey(word)) {
                if (map.get(word)) {
                    count++;
                }
            } else {
                if (isSeq(s, word)) {
                    count++;
                    map.put(word, true);
                } else {
                    map.put(word, false);
                }
            }
        }
        return count;
    }

    private boolean isSeq(String s, String word) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;
                if (j == word.length()) return true;
            }
            i++;
        }
        return j == word.length();
    }

    public static void main(String[] args) {
        int i = new A792_NumMatchingSubseq().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
        System.out.println("i = " + i);
    }
}
