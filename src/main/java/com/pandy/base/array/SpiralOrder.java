package com.pandy.base.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/27
 * <p>
 * 螺旋矩阵
 **/
class SpiralOrder {
    private static List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;

        // 左 上从0开始
        // 下 右 分别是row - 1 和 col - 1
        int l = 0, t = 0, b = row - 1, r = col - 1;

        while (true) {
            // 左右
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);

            // 上下
            if (++t > b) break;
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);

            // 右左
            if (--r < l) break;
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);

            // 下上
            if (--b < t) break;
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if (++l > r) break;
        }
        return res;
    }
}
