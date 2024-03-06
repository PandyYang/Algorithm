package com.pandy.classic_150;

public class A012_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // -------------------------- 元素左边的值 -------------------------
        int[] leftProducts = new int[n];
        // 因为最左边的第一个数据 没有更左的数字 只能是1
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            // 注意
            leftProducts[i] = leftProducts[i-1] * nums[i-1];
        }

        // --------------------------- 元素右边的值 -------------------------
        int[] rightProducts = new int[n];
        rightProducts[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i+1] * nums[i+1];
        }

        // ---------------------------左右的元素相乘-------------------------
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }
        return answer;
    }
}
