package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/5/6
 *
 * 动态规划求解
 * 求解最小路径和
 *
 * 创建二维数组 dp，与原始网格的大小相同，[i][j]dp[i][j] 表示从左上角出发到 (i,j)(i,j) 位置的最小路径和。显然，[0][0]=\textit{grid}[0][0]dp[0][0]=grid[0][0]。对于 dp 中的其余元素，通过以下状态转移方程计算元素值。
 *
 * 当 i>0i>0 且 j=0j=0 时，[i][0]=[i-1][0]+\textit{grid}[i][0]dp[i][0]=dp[i−1][0]+grid[i][0]。
 *
 * 当 i=0i=0 且 j>0j>0 时，[0][j]=[0][j-1]+\textit{grid}[0][j]dp[0][j]=dp[0][j−1]+grid[0][j]。
 *
 * 当 i>0i>0 且 j>0j>0 时，[i][j]=\min([i-1][j],[i][j-1])+\textit{grid}[i][j]dp[i][j]=min(dp[i−1][j],dp[i][j−1])+grid[i][j]。
 *
 * 最后得到 [m-1][n-1]dp[m−1][n−1] 的值即为从网格左上角到网格右下角的最小路径和。
 *
 **/
public class MinPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int row = grid.length, columns = grid[0].length;

        int[][] dp = new int[row][columns];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j <columns ; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }

        return dp[row-1][columns-1];
    }
}
