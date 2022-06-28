package com.pandy.base.array.package01;

/**
 * @author: Pandy
 * @create: 2022/5/6
 *
 * 数组下标的每个元素代表能够跳的数目，判断能否跳到最后一个位置。
 *
 * 思路：
 * 尽可能到达最远位置（贪心）。
 * 如果能到达某个位置，那一定能到达它前面的所有位置。
 **/
public class CanJump {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) return true;
            }
        }
        return false;
    }
}
