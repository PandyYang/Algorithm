package com.pandy.hot100;

public class L53 {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (sum >= 0) {
                sum += num;
            } else {
                sum = num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = L53.maxSubArray(new int[]{-1});
        System.out.println("i = " + i);
    }
}
