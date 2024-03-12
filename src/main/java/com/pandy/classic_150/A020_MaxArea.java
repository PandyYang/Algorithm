package com.pandy.classic_150;

public class A020_MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]); // 当前区域的高度取两个指针对应位置的较小值

            int area = (Math.abs(right - left)) * h; // 计算当前区域的容量

            maxArea = Math.max(maxArea, area); // 更新最大容量

            // 移动较短的那条线段对应的指针
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
