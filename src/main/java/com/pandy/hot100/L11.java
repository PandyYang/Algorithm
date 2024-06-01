package com.pandy.hot100;

public class L11 {
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i <= height.length - 1; i++) {
            int n = height[i];
            int area = 0;
            for (int j = i + 1; j < height.length; j++) {
                area = (j - i) * Math.min(n, height[j]);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            // 计算当前两个指针指向的板子围成的容器的容量
            int area = (right - left) * Math.min(height[left], height[right]);
            // 更新最大值
            max = Math.max(max, area);
            // 移动较短的板子
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        L11 l11 = new L11();
//        int i = l11.maxArea(new int[]{1, 1});
        int i = l11.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println("i = " + i);
    }
}
