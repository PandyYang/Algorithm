package com.pandy.base.array.package01;

/**
 * @author: Pandy
 * @create: 2022/1/14
 * <p>
 * 连续子数组得最大和
 **/
public class GreatestSumOfSubArray {

    public static int greatestSumOfSubArray(int[] arr) {
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

    public static void main(String[] args) {
        int sum = greatestSumOfSubArray(new int[]{-1, 2, -4, 5, 7, 9, 1, 0});
        System.out.println("sum = " + sum);
    }
}
