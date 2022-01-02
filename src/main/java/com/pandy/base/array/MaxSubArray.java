package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/1
 * 求子序列的最大和
 *
 **/
public class MaxSubArray {
    public static int max(int[] arr) {
        // 收集子序列的和
        int res = arr[0];
        // 最大值
        int sum = 0;
        for (int num : arr) {
            if (num > 0) {
                // 子序列最大和
                res += num;
            } else {
                // 此时上一个子序列不可能为最大 初始化坐标为当前的负值
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {-1,-2,-3,-4,-5};
        int max = max(arr);
        System.out.println("max = " + max);
    }
}
