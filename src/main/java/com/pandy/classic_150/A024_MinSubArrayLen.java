package com.pandy.classic_150;

public class A024_MinSubArrayLen {

    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            // 注意这是一个while
            while (sum >= target) {
                minLen = Math.min(right - left  + 1, minLen);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int i = minSubArrayLen(11, new int[]{1, 2, 3, 4, 5});
        System.out.println("i = " + i);
    }
}
