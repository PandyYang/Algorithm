package com.pandy.base.array.package01;

import java.util.Arrays;

/**
 * @author Pandy
 * @date 6/6/2022
 * <p>
 * 分糖果
 * 贪心算法
 * <p>
 * 首先，初始化一个数组 candies，数组长度与评分数组 ratings 相同，全部元素初始化为 1，表示每个孩子至少分配到 1 个糖果。
 * 从左往右遍历评分数组 ratings，对于每个孩子 i，如果 ratings[i] 大于 ratings[i-1]（前一个孩子的评分），
 * 则 candies[i] = candies[i-1] + 1，即当前孩子获得的糖果数比前一个孩子多 1。
 * 再从右往左遍历评分数组 ratings，对于每个孩子 i，如果 ratings[i] 大于 ratings[i+1]（后一个孩子的评分），
 * 且 candies[i] 不大于 candies[i+1]，则 candies[i] = candies[i+1] + 1，即当前孩子获得的糖果数比后一个孩子多 1。
 * 最终，数组 candies 中的每个元素就表示每个孩子实际获得的糖果数，返回 candies 数组的总和即为最少糖果数目。
 *
 *
 * 之所以遍历两次，是因为我们要确保一个孩子的左右相邻的两边都要进行分配糖果数的满足。
 */
public class Candy {

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // 初始化每个孩子至少分配到 1 个糖果

        // 从左往右遍历评分数组，保证评分更高的孩子获得更多的糖果
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 从右往左遍历评分数组，保证评分更高的孩子获得更多的糖果
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // candies[i] 当前孩子的糖果数量
                // candies[i+1] 右相邻孩子所活得的糖果数量 注意+1是因为如果评分大于右边的孩子 那么 他就必须要获取比右边孩子大一个的糖果数量
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // 返回最少糖果数目
        return Arrays.stream(candies).sum();
    }

}
