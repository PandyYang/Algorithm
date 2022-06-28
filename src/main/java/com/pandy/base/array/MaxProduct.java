package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/6/29
 *
 * 子数组的最大乘积
 **/
public class MaxProduct {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int i = maxProduct.maxProduct(new int[]{2, 3, -2, 4});
        System.out.println("i = " + i);
    }
}
