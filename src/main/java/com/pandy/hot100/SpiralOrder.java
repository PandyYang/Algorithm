package com.pandy.hot100;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // 从左到右遍历当前顶部行
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // 从上到下遍历当前最右列
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // 从右到左遍历当前底部行
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // 从下到上遍历当前最左列
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralOrder solution = new SpiralOrder();
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(solution.spiralOrder(matrix)); // 输出: [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
