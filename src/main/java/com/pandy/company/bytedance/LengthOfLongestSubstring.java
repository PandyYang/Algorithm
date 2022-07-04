package com.pandy.company.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 无重复的最长子串
 * <p>
 * 使用map作为滑动窗口，每次遇见重复的数字，更新下当前位置和开始扫描位置的距离，记录最大值。
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
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
