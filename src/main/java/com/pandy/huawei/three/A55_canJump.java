package com.pandy.huawei.three;

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 *
 * 从后往前遍历，设置目标tar，如果 A 位置能够到达 tar ，则把 tar 更新为 A 的位置
 */
public class A55_canJump {
    public boolean canJump(int[] nums) {
        int tar = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            if (i + nums[i] >= tar) {
                tar = i;
            }
        }
        return tar == 0;
    }
}
