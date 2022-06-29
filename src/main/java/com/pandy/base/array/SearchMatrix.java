package com.pandy.base.array;

/**
 * @author Pandy
 * @date 6/6/2022
 * <p>
 * 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 思路
 * 若将矩阵每一行拼接在上一行的末尾，则会得到一个升序数组，我们可以在该数组上二分找到目标元素。
 * 代码实现时，可以二分升序数组的下标，将其映射到原矩阵的行和列上。
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] < target) {
                m++;
            } else {
                n--;
            }
        }
        return false;
    }
}
