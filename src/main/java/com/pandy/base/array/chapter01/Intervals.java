package com.pandy.base.array.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/4/4
 *
 * 合并区间
 **/
public class Intervals {

    public int[][] merge(int[][] intervals) {

        List<int[]> list = new ArrayList<>();

        // 按照左边的字符大小排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int left = intervals[i][0];  // 单个区间的start
            int right = intervals[i][1]; // 单个区间的end

            while (i < n - 1 && right >= intervals[i+1][0]) {
                // 单个区间的end 大于 下一个区间的start  比较第一个区间的end和第二个区间的end取最大的
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,4}, {4,5}};
        Intervals intervals = new Intervals();
        int[][] merge = intervals.merge(arr);
        System.out.println("merge = " + Arrays.deepToString(merge));
    }
}
