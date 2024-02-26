package com.pandy.base.array;

public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left <= i && product >= k) {
                // 使用一个 while 循环，当 product 大于或等于 k 时，从 product 中除去左边界的元素 (nums[left]) 并移动左边界（left++）。
                product /= nums[left++];
            }
            // 当窗口内的乘积小于 k 时，从当前左边界到右边界的所有子数组都会满足条件。
            count += i >= left? i - left + 1 : 0;
        }
        return count;
    }
}
