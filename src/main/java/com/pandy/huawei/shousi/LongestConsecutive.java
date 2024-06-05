package com.pandy.huawei.shousi;

import java.util.HashSet;

public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        for (Integer num : set) {
            if (set.contains(num)) {
                int cur = num;
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    count += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
