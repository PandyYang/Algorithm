package com.pandy.huawei.three;

import java.util.HashMap;

public class A409_LongestPalindrome {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        boolean hasOdd = false;
        for (Character character : map.keySet()) {
            Integer num = map.get(character);
            if (num % 2 == 0) {
                count += num;
            } else {
                count += num - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int i = new A409_LongestPalindrome().longestPalindrome("abccccdd");
        System.out.println("i = " + i);
    }
}
