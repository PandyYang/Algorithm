package com.pandy.base.array.package01;

/**
 * @author Pandy
 * @date 16/6/2022
 *
 * 寻找山峰
 *
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;

            // 最大的在右边
            if (nums[m] < nums[m + 1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
