package com.pandy.codetop;

import java.util.HashMap;

public class C001_LengthOfLongestSubstring {

    // 最长无重复的子串
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> dic = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (dic.containsKey(s.charAt(j))) {
                i = Math.max(i, dic.get(s.charAt(j)));
            }
            dic.put(s.charAt(j), j);
            res= Math.max(res, j - i);
        }
        return res;
    }


    public static void main(String[] args) {
        int pwwkew = C001_LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println("pwwkew = " + pwwkew);
    }
}
