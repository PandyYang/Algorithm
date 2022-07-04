package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/2
 **/
public class MinSubArrayLen {
    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        int min = minSubArrayLen.min(7, new int[]{2, 3, 1, 2, 4, 3});
        System.out.println("min = " + min);
    }

    public int min(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
