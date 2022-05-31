package com.pandy.base.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/3/28
 *
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 排序 哈希 位运算
 **/
public class MissingNum {

    public static int missingNum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return n;
    }

    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        int missing = -1;
        for (int i = 0; i <= n; i++) {
            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        int i = missingNum(new int[]{0, 1, 2, 4, 5});
        System.out.println("i = " + i);
    }
}
