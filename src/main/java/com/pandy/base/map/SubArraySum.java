package com.pandy.base.map;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumToCount = new HashMap<>();
        // key为前i个数字之和 value为每个和出现的次数
        sumToCount.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            // 子数组之和
            sum += num;
            // sum - k
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum, 0) +1);
        }
        return count;
    }
}
