package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 跳跃游戏
 **/
public class JumpGame {

    public boolean canJump(int[] arr) {
        if (arr == null || arr.length < 2) return true;

        int max = 0;

        for (int i = 0; i <= max; i++) {
            // 找最大值
            max = Math.max(max, i + arr[i]);
            // 比较最大值和数组长度
            if (max >= arr.length - 1) return true;
        }
        return false;
    }
}
