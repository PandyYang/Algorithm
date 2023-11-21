package com.pandy.company.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 无重复的最长子串
 * <p>
 * 使用map作为滑动窗口，每次遇见重复的数字，更新下当前位置和开始扫描位置的距离，记录最大值。
 **/
public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        int max = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(map.get(c) + 1, start); // 第一次出现重复元素的位置就是窗口的开始位置，也就是最左边的位置
            }
            max = Math.max(max, i - start + 1); //  i - start + 1 是当前窗口大小
            map.put(c, i); // 记录当前元素的位置
        }
        return max;
    }

}
