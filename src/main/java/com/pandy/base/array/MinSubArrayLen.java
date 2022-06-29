package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/6/29
 *
 * 长度最小的子数组
 *
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
 * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * [1,4,4]
 **/
public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        int len = 0;

        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {

                // j - i是窗口的大小
                len = len == 0 ? j - i + 1 : Math.min(len, j - i + 1);
                // i是窗口的左边
                sum -= nums[i++];
            }
        }
        return len;
    }
}
