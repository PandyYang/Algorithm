package com.pandy.classic_150;

import java.util.HashSet;

public class A025_LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                } else {
                    break;
                }
                if (max < set.size()) {
                    max = set.size();
                }
            }
        }
        return max;
    }
}
