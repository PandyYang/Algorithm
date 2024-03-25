package com.pandy.codetop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C026_MergeArr {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 根据区间的起始位置进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        // 添加第一个区间到结果列表
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            // 获取结果列表中的最后一个区间
            int[] lastInterval = result.get(result.size() - 1);
            // 如果当前区间的起始位置小于或等于最后一个区间的结束位置，说明重叠
            if (intervals[i][0] <= lastInterval[1]) {
                // 合并区间
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                // 如果不重叠，直接添加当前区间到结果列表
                result.add(intervals[i]);
            }
        }

        // 将结果列表转换为数组形式返回
        return result.toArray(new int[result.size()][]);
    }

}
