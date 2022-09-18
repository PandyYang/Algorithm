package com.pandy.company.bytedance;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 最大的乘积
 **/
public class MaximumProduct {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
