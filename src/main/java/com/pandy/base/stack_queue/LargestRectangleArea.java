package com.pandy.base.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Pandy
 * @date 5/6/2022
 * <p>
 * 柱状图中的最大矩形
 * <p>
 * 单调栈：在一维数组中对每一个数找到第一个比自己小的元素。
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];

        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }

        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                res = Math.max(res, (i - stack.peek() - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    // 双指针法
    public int largestRectangleArea2(int[] heights) {
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            int value = heights[i];
            while (left >= 0) {
                if (heights[left] < value) {
                    break;
                }
                left--;
            }

            while (right < heights.length) {
                if (heights[right] < value) {
                    break;
                }
                right++;
            }
            int res = (right - left - 1) * value;
            if (res > result) result = res;
        }
        return result;
    }
}
