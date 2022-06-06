package com.pandy.base.stack_queue;

/**
 * @author Pandy
 * @date 5/6/2022
 * 最大的矩形面积
 */
public class MaximalRectangle {

    LargestRectangleArea largestRectangleArea = new LargestRectangleArea();

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int col = matrix.length;
        int row = matrix[0].length;
        int[] height = new int[row];
        int ans = 0;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                // 列的高度
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea.largestRectangleArea(height));
        }
        return ans;
    }
}
