package com.pandy.base.simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pandy
 * @date 6/7/2022
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int up = 0, down = row - 1, left = 0, right = col - 1;
        while (true) {

            // 从左到右
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }

            if (++up > down) break;
            // 从上到下
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }

            // 从右到左
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }

            if (--down < up) break;
            // 从下到上
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }

            if (++left > right) break;
        }
        return res;
    }
}
