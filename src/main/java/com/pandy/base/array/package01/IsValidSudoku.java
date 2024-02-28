package com.pandy.base.array.package01;

/**
 * @author: Pandy
 * @create: 2022/3/26
 * 有效的数独
 **/
public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // board[i][j]是某个点的值
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    // blockIndex是九宫格的索引
                    // x x x
                    // x x x
                    // x x x
                    int blockIndex = i / 3 * 3 + j / 3;
                    // 检查当前数字num在当前格子所在的行 列 九宫格种是否出现过
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] arr = new char[][]
                {
                          {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        boolean validSudoku = isValidSudoku(arr);
        System.out.println("validSudoku = " + validSudoku);
    }
}
