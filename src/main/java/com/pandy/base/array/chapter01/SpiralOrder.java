package com.pandy.base.array.chapter01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/27
 *
 * 螺旋矩阵
 **/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }

        int rows = matrix.length, columns = matrix[0].length;

        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {

            for (int column = left; column <= right; column++) {
                order.add(matrix[top][column]);
            }
            for (int row = top + 1; row <= bottom; row++) {
                order.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {
                    order.add(matrix[bottom][column]);
                }
                for (int row = bottom; row > top; row--) {
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

    private static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        // 左 上从0开始
        // 下 右 分别是row - 1 和 col - 1
        int l = 0, t = 0, b = row - 1, r  = col - 1;

        while (true) {
            for (int i = l; i<= r; i++) res.add(matrix[t][i]);

            if (++t > b) break;
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);

            if (--r < l) break;
            for (int i = r; i>= l; i--) res.add(matrix[b][i]);

            if (--b < t) break;
            for (int i = b; i>= t; i--) res.add(matrix[i][l]);
            if (++l > r) break;;
        }
        return res;
    }
}
