package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/14
 * <p>
 * 连续子数组得最大和
 **/
public class GreatestSumOfSubArray {

    public int greatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) return 0;

        int max = arr[0];
        int sum = 0;

        for (int i : arr) {
            if (sum + i > i) {
                sum += i;
            } else {
                sum = i;
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
