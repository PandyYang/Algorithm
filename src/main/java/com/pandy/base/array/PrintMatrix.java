package com.pandy.base.array;

import java.util.ArrayList;

/**
 * @author: Pandy
 * @create: 2022/1/14
 * 
 * 逆时针打印数字
 * 
 * 通过4个指针，表示可打印区域，并对区域进行收缩
 * 非 n*n 的矩阵，对于剩余非 4 边遍历的元素，要考虑边界
 **/
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix.length == 0) return res;

        if (matrix.length == 1) {
            for (int i : matrix[0]) {
                res.add(i);
            }
            return res;
        }

        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        for (; left <= right && top <= bottom; ) {
            if (top == bottom) {
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                break;
            }

            if (left == right) {
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][left]);
                }
                break;
            }

            for (int p = left; p <= right; p++) {
                res.add(matrix[top][p]);
            }
            top++;

            for (int p = top; p <= bottom; p++) {
                res.add(matrix[p][right]);
            }
            right--;

            for (int p = right; p >= left; p--) {
                res.add(matrix[bottom][p]);
            }
            bottom--;

            for (int p = bottom; p >= top; p--) {
                res.add(matrix[p][left]);
            }
            left++;
        }
        return res;
    }
}
