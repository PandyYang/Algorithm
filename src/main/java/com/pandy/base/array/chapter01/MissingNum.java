package com.pandy.base.array.chapter01;

/**
 * @author: Pandy
 * @create: 2022/3/28
 *
 * 数组中缺失的数字 二分法求解
 *
 * 只要是有序的数组 都可以使用二分法进行查找
 **/
public class MissingNum {
    
    public int missingNum(int[] nums) {
        int i = 0, j = nums.length -1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}
