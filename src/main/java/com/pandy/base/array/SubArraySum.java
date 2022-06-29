package com.pandy.base.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/6/29
 *
 * 和为k的子数组
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 **/
public class SubArraySum {

    public int subArraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySum subArraySum = new SubArraySum();
        int i = subArraySum.subArraySum(new int[]{1, 1, 1}, 2);
        System.out.println("i = " + i);
    }
}
