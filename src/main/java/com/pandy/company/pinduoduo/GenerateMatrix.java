package com.pandy.company.pinduoduo;

/**
 * @author: Pandy
 * @create: 2022/7/7
 **/
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {

        int[][] res = new int[n][n];
        int up = 0, down = n - 1, right = n - 1, left = 0, index = 1;
        while (index <= n * n) {
            for (int i = left; i <= right; i++) {
                res[up][i] = index++;
            }

            up++;
            for (int i = up; i <= down; i++) {
                res[i][right] = index++;
            }

            right--;
            for (int i = right; i >= left; i++) {
                res[down][i] = index++;
            }

            down--;
            for (int i = down; i >= up; i++) {
                res[i][left] = index++;
            }
            left++;
        }
        return res;
    }
}
