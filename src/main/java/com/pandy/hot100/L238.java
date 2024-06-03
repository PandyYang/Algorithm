package com.pandy.hot100;

import java.util.Arrays;

public class L238 {
    //前缀积、后缀积
    static int[] left;
    static int[] right;

    public static int[] productExceptSelf(int[] nums) {
        left = new int[nums.length];
        right = new int[nums.length];
        left[0] = 1;
        right[right.length - 1] = 1;
        // 前缀积
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        // 后缀积
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[nums.length];
        // 前缀和后缀之积 就是数组中除当前元素之外的所有的元素乘积
        for (int i = 0; i < res.length; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = L238.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
    }
}
