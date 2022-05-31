package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/1
 * 求子序列的最大和
 **/
public class MaxSubArray {
    public static int max(int[] arr) {
        // 收集子序列的和
        int res = arr[0];
        // 最大值
        int sum = 0;

        for (int i : arr) {
            // 主要sum大于0 最大和肯定包含sum部分
            if (sum > 0) {
                // 子序列最大和
                sum += i;
            } else {
                // 此时上一个子序列不可能为最大 初始化坐标为当前的负值
                sum = i;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max = max(arr);
        System.out.println("max = " + max);
    }
}
