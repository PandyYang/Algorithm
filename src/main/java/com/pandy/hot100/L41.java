package com.pandy.hot100;

import java.util.Arrays;

public class L41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // 将每个正整数放在对应的索引的位置上 nums[i]的正确位置是nums[nums[i-1]]
        // 例如如果nums[i]是3，那么会出现在索引2的位置上
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // 之后再便利数组 找到第一个nums[i] != i+1的位置
        // 比如nums[0]不为1，最小的正整数就是1
        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return n+1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        L41 l41 = new L41();
        int i = l41.firstMissingPositive(new int[]{3, 2, -1});
        System.out.println("i = " + i);
    }
}
