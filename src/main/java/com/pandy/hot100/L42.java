package com.pandy.hot100;

public class L42 {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];

        // 左侧最大高度
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            // 当前位置能接的雨水量等于左右两侧最大高度的较小值减去当前高度
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
    }

    public static void main(String[] args) {
        int trap = L42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println("trap = " + trap);
    }
}
