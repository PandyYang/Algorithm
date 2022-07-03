package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 最大正方形
 *
 * 方法一：暴力法
 * 由于正方形的面积等于边长的平方，因此要找到最大正方形的面积，首先需要找到最大正方形的边长，然后计算最大边长的平方即可。
 *
 * 暴力法是最简单直观的做法，具体做法如下：
 *
 * 遍历矩阵中的每个元素，每次遇到 11，则将该元素作为正方形的左上角；
 *
 * 确定正方形的左上角后，根据左上角所在的行和列计算可能的最大正方形的边长（正方形的范围不能超出矩阵的行数和列数），
 * 在该边长范围内寻找只包含 11 的最大正方形；
 *
 * 每次在下方新增一行以及在右方新增一列，判断新增的行和列是否满足所有元素都是 11。
 *
 **/
public class MaximalSquare {

    public int maximumSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxSide;

        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    // 遇到一个1 作为正方形的左上角
                    maxSide = Math.max(maxSide, 1);
                    // 计算可能的最大边长
                    int currentMaxSide = Math.min(rows - i, columns - i);

                    for (int k = 1; k < currentMaxSide; k++) {
                        // 判断新增的一行一列是否均为1
                        boolean flag = true;
                        if (matrix[i+k][j+k] == '0') break;
                        for (int m = 0; m < k; m++) {
                            if (matrix[i+k][j+m] == '0' || matrix[i+m][j+k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}
