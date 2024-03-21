package com.pandy.codetop;

import java.util.Arrays;
import java.util.Collections;

public class C010_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int jValue = target - nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] == jValue) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
