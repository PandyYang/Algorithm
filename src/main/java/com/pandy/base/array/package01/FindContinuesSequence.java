package com.pandy.base.array.package01;

import java.util.ArrayList;

/**
 * @author: Pandy
 * @create: 2022/1/15
 *
 * 和为s的连续子序列
 *
 * 解法1： 暴力解法
 *
 * 解法2： 使用等差数列
 **/
public class FindContinuesSequence {
    public static ArrayList<ArrayList<Integer>> findContinuesSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        for (int i = 1; i < sum; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int num = 0;
            for (int j = 1; j < sum; j++) {
                num = num + j;
                if (num <= sum) {
                    list.add(j);
                }
                if (num >= sum) {
                    break;
                }
            }

            if (num == sum) {
                lists.add(list);
            }
        }
        return lists;
    }

    public static ArrayList<ArrayList<Integer>> findContinuesSequence2(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 动态窗口的两端
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            //相等，那么就将窗口范围的所有数添加进结果集
            if (cur == sum) {
                // 由于是连续的，差为1的一个序列，那么求和公式是(a0+an)*n/2
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i++) {
                    list.add(i);
                }
                result.add(list);
                //条件满足，窗口往后滑动一个
                plow++;
                phigh++;
                //如果当前窗口内的值之和小于sum，那么右边窗口右移一下
            } else if (cur < sum) {
                phigh++;
            } else {
                //如果当前窗口内的值之和大于sum，那么左边窗口右移一下
                plow++;
            }
        }
        return result;
    }
}
