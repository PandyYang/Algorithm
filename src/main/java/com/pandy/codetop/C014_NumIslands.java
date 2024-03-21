package com.pandy.codetop;

/**
 * 遍历给定的二维网格。
 * 当遇到一个值为'1'的单元格时，启动深度优先搜索。
 * 将当前单元格标记为已访问（例如，将值从'1'改为'0'，或者使用另外一个数据结构来记录访问状态）。
 * 递归地在四个方向（上、下、左、右）执行深度优先搜索。
 * 继续步骤1和步骤2，直到遍历完所有单元格。
 * 每次启动深度优先搜索时，岛屿数量加1。
 */
public class C014_NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numsIslands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    numsIslands += dfs(grid, i, j);
                }
            }
        }
        return numsIslands;
    }

    private int dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j > grid[i].length || grid[i][j] == '0') {
            return 0;
        }

        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
        return 1;
    }
}
