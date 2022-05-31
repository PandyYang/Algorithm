package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * 
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * 
 * 对于每个字符 S[i]，试图找出距离向左或者向右下一个字符 C 的距离。答案就是这两个值的较小值。
 * 算法
 * 从左向右遍历，记录上一个字符 C 出现的位置 prev，那么答案就是 i - prev。
 * 从右想做遍历，记录上一个字符 C 出现的位置 prev，那么答案就是 prev - i。
 * 这两个值取最小就是答案。
 **/
public class ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        int N = s.length();
        int[] ans = new int[N];
        int prev = Integer.MIN_VALUE / 2;

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = i - prev;
        }

        prev = Integer.MAX_VALUE / 2;
        for (int i = N - 1; i >= 0; i--) {
            if (s.charAt(i) == c) prev = i;
            ans[i] = Math.min(ans[i], prev - i);
        }
        return ans;
    }
}
