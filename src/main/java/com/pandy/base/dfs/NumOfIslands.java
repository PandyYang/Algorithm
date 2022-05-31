package com.pandy.base.dfs;

/**
 * @author Pandy
 * @date 31/3/2022
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
