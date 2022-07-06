package com.pandy.base.greedy;

class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[] f = new int[m];

        // 石头在门口
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                // 有障碍物
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }
                // 为了不越界
                if (j - 1 >= 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[m - 1];
    }
}
