package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * 子数组的最大和
 **/
public class MaxSubArray {

    public static void main(String[] args) {
        MaxSubArray maxSunArray = new MaxSubArray();
        int i = maxSunArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println("i = " + i);
    }

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum > 0) {
                // 一直是正数 那就加呗
                sum += nums[i];
            } else {
                // 快要是负了 赶紧拉一把
                sum = nums[i];
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
