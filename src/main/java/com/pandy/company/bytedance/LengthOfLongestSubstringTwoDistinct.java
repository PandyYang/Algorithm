package com.pandy.company.bytedance;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/7/2
 *
 * 最多包含两个不重复元素的最长子串、
 *
 *定义一个 HashMap，key 为字符，value 为该字符在区间 left 到 right 中最靠右的那个索引。
 *
 * 于是，right 每往右走一步，都进行以下操作：
 *
 * 1、map.put(s.charAt(right), right)，如果 s.charAt(right) 已存在，刚好顺便把它更新到最靠右；
 * 不存在的话，添加后就是唯一的存在，value 也是最靠右的。
 *
 * 2、判断 map 里面的元素是不是等于三个，如果是，说明得删除一个，找出三个元素 value 最小的那个进行删除；
 **/
public class LengthOfLongestSubstringTwoDistinct {
    public int length(String s) {
        int len = s.length();
        if (len < 3) return len;

        int left = 0, right = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (right < len) {
            map.put(s.charAt(right), right);
            right++;
            if (map.size() == 3) {
                int index = Collections.min(map.values());
                map.remove(s.charAt(index));
                // 第一个元素出现的位置
                left = index + 1;
            }
            // 最新出现的 减去旧的最左边元素
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstringTwoDistinct length = new LengthOfLongestSubstringTwoDistinct();
        int eceba = length.length("eceba");
        System.out.println("eceba = " + eceba);
    }
}
