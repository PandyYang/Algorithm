package com.pandy.base.greedy;

/**
 * @author: Pandy
 * @create: 2022/4/4
 *
 *
 * 给定一个非负整数数组nums，你最初位于数组的第一个位置，数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是判断你是否能够到达数组的最后一个位置。
 *
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
