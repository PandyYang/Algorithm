package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/2
 * <p>
 * 最长连续递增的子序列
 *
 * <p>
 * 方法一：动态规划
 * 思路与算法
 * <p>
 * 定义 {dp}[i]dp[i] 为考虑前 ii 个元素，以第 ii 个数字结尾的最长上升子序列的长度，注意 {nums}[i]nums[i] 必须被选取。
 * <p>
 * 我们从小到大计算 {dp}dp 数组的值，在计算 {dp}[i]dp[i] 之前，我们已经计算出 {dp}[i-1]dp[0…i−1] 的值，则状态转移方程为：
 * <p>
 * {dp}[i] = \max({dp}[j]) + 1, \text{其中} \, 0 \leq j < i \, \text{且} \, {num}[j]<{num}[i]
 * dp[i]=max(dp[j])+1,其中0≤j<i且num[j]<num[i]
 * <p>
 * 即考虑往 {dp}[i-1]dp[0…i−1] 中最长的上升子序列后面再加一个 {nums}[i]nums[i]。由于 {dp}[j]dp[j] 代表 {nums}[j]nums[0…j] 中以 {nums}[j]nums[j] 结尾的最长上升子序列，
 * 所以如果能从 {dp}[j]dp[j] 这个状态转移过来，那么 {nums}[i]nums[i] 必然要大于 {nums}[j]nums[j]，才能将 {nums}[i]nums[i] 放在 {nums}[j]nums[j] 后面以形成更长的上升子序列。
 * <p>
 * 最后，整个数组的最长上升子序列即所有 {dp}[i]dp[i] 中的最大值。
 **/
public class LengthOfLIS {
    public int length(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
