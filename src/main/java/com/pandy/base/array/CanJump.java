package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/5/6
 *
 * 数组下标的每个元素代表能够跳的数目，判断能否跳到最后一个位置。
 *
 * 贪心算法求解： https://leetcode-cn.com/problems/jump-game/solution/tiao-yue-you-xi-by-leetcode-solution/
 **/
public class CanJump {

    public boolean canJump(int[] arr) {
        if (arr == null || arr.length < 2) return true;

        int max = 0;

        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + arr[i]);
            if (max >= arr.length - 1) return true;
        }
        return false;
    }
}
