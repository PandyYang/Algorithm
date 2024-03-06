package com.pandy.classic_150;

public class A010_CanJumpII {
    public static int jump(int[] nums) {
        int n = nums.length;
        int jumps = 0; // 记录跳跃次数
        int farthest = 0; // 记录当前能够跳到的最远位置
        int currentEnd = 0; // 记录当前跳跃的结束位置

        for (int i = 0; i < n - 1; i++) {
            // 更新当前能够跳到的最远位置
            farthest = Math.max(farthest, i + nums[i]);

            // 如果已经到达当前跳跃的结束位置，更新跳跃次数并更新当前跳跃的结束位置
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}
