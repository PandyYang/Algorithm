package com.pandy.base.traceback;

class ExistWord {

    private boolean find;

    public boolean exist(char[][] board, String word) {
        if(board == null)  return false;

        int m = board.length, n = board[0].length;

        boolean[][] valid = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(0, valid, i, j, board, word);
            }
        }
        return find;
    }

    public void dfs(int pos, boolean[][]valid, int i, int j, char[][] board, String word) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || valid[i][j] || find || board[i][j] != word.charAt(pos)) {
            return;
        }

        if(pos == word.length() - 1) {
            find = true;
            return;
        }

        valid[i][j] = true;
        dfs(pos + 1, valid, i + 1, j, board, word);
        dfs(pos + 1, valid, i - 1, j, board, word);
        dfs(pos + 1, valid, i, j + 1, board, word);
        dfs(pos + 1, valid, i, j - 1, board, word);
        valid[i][j] = false;
    }

    public static void main(String[] args) {
        ExistWord solution = new ExistWord();
        char[][] chars = new char[][] {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean exist = solution.exist(chars, word);
        System.out.println(exist);
    }
}
