package com.pandy.base.math;

/**
 * @author Pandy
 * @date 23/3/2022
 * 只出现一次的数字 使用位运算进行解决
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,3,3,4,4,4,4,5,5};
        int i = singleNumber(arr);
        System.out.println("i = " + i);
    }
}
