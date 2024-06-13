package com.pandy.huawei.three;

import java.util.HashMap;
import java.util.Map;

public class A594_FindLHS {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 统计每个元素的频次
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // 遍历哈希表，检查和谐子序列的长度
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {

            int num = entry.getKey();
            int count = entry.getValue();

            if (frequencyMap.containsKey(num + 1)) {
                maxLength = Math.max(maxLength, count + frequencyMap.get(num + 1));
            }
        }

        return maxLength;
    }
}
