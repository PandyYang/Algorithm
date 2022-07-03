package com.pandy.company.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 合并区间
 **/
public class MergeII {

    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            return o1[0] - o2[0];
        });

        int i = 0, n = intervals.length;
        while (i < n) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            while (i < n - 1 && right >= intervals[i+1][0]) {
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }
}
