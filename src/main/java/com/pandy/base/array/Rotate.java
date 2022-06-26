package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/3/26
 * 
 * 旋转图像
 * 
 * 由于矩阵中的行列从 00 开始计数，因此对于矩阵中的元素 matrix[row][col]
 * 在旋转后，它的新位置为[col][n−row−1]。
 **/
public class Rotate {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] matrix_new = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix_new[j][n - i - 1] = matrix[i][j];
            }
        }

        // 重新赋值回去
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix_new[i][j];
            }
        }
    }
}
