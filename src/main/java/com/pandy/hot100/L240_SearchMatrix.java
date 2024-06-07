package com.pandy.hot100;

public class L240_SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        while (i < n && m >= 0) {
            if (matrix[m][i] == target) {
                return true;
            } else if (matrix[m][i] < target) {
                i++;
            } else {
                m--;
            }
        }
        return false;
    }
}
