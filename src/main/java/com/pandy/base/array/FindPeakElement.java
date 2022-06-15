package com.pandy.base.array;

/**
 * @author Pandy
 * @date 16/6/2022
 *
 * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
 * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
 * 2.假设 nums[-1] = nums[n] = -\infty−∞
 * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * 4.你可以使用O(logN)的时间复杂度实现此问题吗？
 *
 * 寻找山峰
 */
public class FindPeakElement {
    public int findPeakElement (int[] nums) {
        // write code here
        int l = 0;
        int r = nums.length - 1;
        while(l < r) {
            int m = (l + r) / 2;

            // 最大的在右边
            if(nums[m]  <  nums[m+1]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return r;
    }
}
