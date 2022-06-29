package com.pandy.base.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/6/29
 **/
public class ReconstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        List<int[]> list = new ArrayList<>();

        for (int[] each : people) {
            list.add(each[1], each);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
