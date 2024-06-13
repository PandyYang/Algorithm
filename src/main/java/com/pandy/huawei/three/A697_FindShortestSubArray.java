package com.pandy.huawei.three;

import java.util.HashMap;
import java.util.Map;

public class A697_FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> firstPositionMap = new HashMap<>();
        Map<Integer, Integer> lastPositionMap = new HashMap<>();

        int maxDegree = 0;

        // 统计每个元素的频次，并记录第一次和最后一次出现的位置
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            maxDegree = Math.max(maxDegree, countMap.get(num));
            if (!firstPositionMap.containsKey(num)) {
                firstPositionMap.put(num, i);
            }
            lastPositionMap.put(num, i);
        }

        int minLength = nums.length;

        // 找到具有最大频次的元素，计算其最短连续子数组的长度
        for (int num : countMap.keySet()) {
            if (countMap.get(num) == maxDegree) {
                int length = lastPositionMap.get(num) - firstPositionMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }
}
