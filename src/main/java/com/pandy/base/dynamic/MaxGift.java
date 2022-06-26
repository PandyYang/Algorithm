package com.pandy.base.dynamic;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/6
 * 
 * 礼物的最大价值
 * 
 * 在一个 m*n 的棋盘中的每一个格都放一个礼物，每个礼物都有一定的价值（价值大于0）.
 * 你可以从棋盘的左上角开始拿各种里的礼物，并每次向左或者向下移动一格，
 * 直到到达棋盘的右下角。给定一个棋盘及上面个的礼物，请计算你最多能拿走多少价值的礼物？
 * 
 * 
 * 解题思路
 * 动态规划，定义 f(x,y)f(x,y) 表示x,y点上能获取的最大数
 * 状态转移方程： f(x,y)=\max(f(x-1,y),f(x,y-1))+g(x,y)f(x,y)=max(f(x−1,y),f(x,y−1))+g(x,y)
 * 可以考虑使用一维数组进行记录
 **/
public class MaxGift {

    public int maxGift(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int a = i > 0 ? matrix[i - 1][j] : 0;
                int b = j > 0 ? matrix[i][j - 1] : 0;
                matrix[i][j] += Math.max(a, b);
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        return matrix[matrix.length - 1][matrix[0].length - 1];
    }
}
