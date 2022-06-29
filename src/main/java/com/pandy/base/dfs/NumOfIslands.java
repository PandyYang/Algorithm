package com.pandy.base.dfs;

/**
 * @author Pandy
 * @date 31/3/2022
 * <p>
 * 给你一个'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumOfIslands {

    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '0'}
        };

        NumOfIslands numOfIslands = new NumOfIslands();
        int i = numOfIslands.numOfIslands(arr);
        System.out.println("i = " + i);
    }

    public int numOfIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int nr = grid.length;
        int nc = grid[0].length;

        // 处理每一个小的区间
        int res = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    ++res;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 对每一个区域进行深度优先遍历
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        // 跳过越界或者不为1的地方  只寻找范围内的岛屿
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        //
        grid[r][c] = '0';
        // 上
        dfs(grid, r - 1, c);
        // 下
        dfs(grid, r + 1, c);
        // 左
        dfs(grid, r, c - 1);
        // 右
        dfs(grid, r, c + 1);
    }
}
