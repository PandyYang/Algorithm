package com.pandy.company.pdd;

/**
 * @author: Pandy
 * @create: 2022/7/7
 **/
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int res = Integer.MIN_VALUE;

        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
            }

            right++;

            while (k < 0) {
                if (nums[left] == 0) k++;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}
