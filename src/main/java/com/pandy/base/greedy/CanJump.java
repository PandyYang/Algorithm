package com.pandy.base.greedy;

/**
 * @author: Pandy
 * @create: 2022/4/4
 **/
public class CanJump {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;

        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                // 查看是否可以跳出数组
                if (rightmost > n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
