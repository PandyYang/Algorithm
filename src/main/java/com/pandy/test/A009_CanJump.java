package com.pandy.test;

public class A009_CanJump {
    public boolean canJump(int[] nums) {
        int reachable = 0; // 表示当前能够到达的最远位置
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) { // 如果当前位置超出了当前能够到达的最远位置，则无法到达最后一个位置
                return false;
            }
            reachable = Math.max(reachable, i + nums[i]); // 更新当前能够到达的最远位置
        }
        return true; // 循环结束后未发现无法到达最后一个位置的情况，返回true
    }

}
