package com.pandy.huawei.three;

public class A453_MinMoves {
    public int minMovies(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }

        int moves = 0;
        for (int num : nums) {
            moves += num - min;
        }

        return moves;
    }
}
