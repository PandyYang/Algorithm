package com.pandy.base.array;

import java.util.ArrayList;

/**
 * @author: Pandy
 * @create: 2022/1/15
 *
 * 和为s的连续子序列
 **/
public class FindNumberWithSum {

    public ArrayList<Integer> find(int[] arr, int sum) {
        ArrayList<Integer> res= new ArrayList<>();

        if (arr == null || arr.length == 1) return res;

        int start = 0, end = arr.length - 1;

        int minMulti = Integer.MAX_VALUE;
        int a = -1, b = -1;

        while (start < end) {
            int t = arr[start] + arr[end];
            if (t == sum) {
                int multi = arr[start] * arr[end];
                if (multi < minMulti) {
                    a = arr[start];
                    b = arr[end];
                    minMulti = multi;
                }
                start ++;
                end --;
            } else if (t > sum) end--;
            else end ++;
        }

        if (a == -1 || b == -1) {
            return res;
        }
        res.add(a);
        res.add(b);

        return res;
    }
}
