package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * 合并区间
 */
public class A56_MergeArr {
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();

        Arrays.stream(intervals).sorted(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] currentInterval = intervals[0];
        res.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            // 没有分裂 一直融合
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // 有隔阂 则加入
                currentInterval = interval;
                res.add(currentInterval);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] merge = new A56_MergeArr().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(merge);
    }
}
