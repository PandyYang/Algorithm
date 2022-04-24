package com.pandy.base.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pandy
 * @date 30/3/2022
 *
 * 和为s的连续正数序列
 */
public class FindContinuousSequence {

    public int[][] find(int target)  {
        int i = 1, j = 2, s = 3;
        List<int[]> res = new ArrayList<>();
        while (i < j) {

            // 当S = target 记录连续的整数序列 并向右移动左边界 i = i + 1
            if (s == target) {
                int[] ans = new int[j - i + 1];
                for(int k = i; k <= j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }

            // s > target 向右移动左边界 i = i + 1，并更新元素和S
            if (s >= target) {
                s -= i;
                i++;
            } else {
            // s < target 向右移动右边界 并更新元素和S
                j++;
                s += j;
            }
        }
        return res.toArray(new int[0][]);
    }
}
