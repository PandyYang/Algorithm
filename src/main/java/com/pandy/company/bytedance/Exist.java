package com.pandy.company.bytedance;

/**
 *
 *
 * 单词搜索
 *
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 */

class Exist {

    int m = 0;
    int n = 0;
    boolean[][] visited;
    int[][] direct = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //起点如果不是word的首字符，那就跳过当前位置，不从这里开始遍历
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }

                visited = new boolean[m][n];
                //如果从(i,j)开始遍历能找到word在网络中，则返回true；否则继续从头开始遍历
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int cur, boolean[][] visited) {
        //如果cur指针越界了，则证明已经找到与word匹配的所有字符了
        if (cur == word.length()) {
            return true;
        }
        //i和j如果越界则返回false
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        //如果当前网络字符不等于word的第cur个字符，或者当前字符已经被访问，则false
        if (board[i][j] != word.charAt(cur) || visited[i][j]) {
            return false;
        }
        //回溯
        visited[i][j] = true;
        //如果从当前点(i,j)散发的四个方向中有一个方向能成功匹配剩下的字母，则可以返回true
        for (int[] dir : direct) {

            if (dfs(board, word, i + dir[0], j + dir[1], cur + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        //前面如果没有找到完整匹配的结果则返回false
        return false;
    }
}
