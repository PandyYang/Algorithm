package com.pandy.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56 {
    public static int[][] merge(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged =  new ArrayList<>();

        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];


            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        L56.merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}});
    }
}
