package com.pandy.huawei.shousi;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longest(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (Integer count : countMap.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                // 如果字符 'a' 出现 5 次，那么 5 - 1 = 4 次 'a' 可以构造对称部分的回文串：
                length += count - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) length++;
        return length;
    }
}
