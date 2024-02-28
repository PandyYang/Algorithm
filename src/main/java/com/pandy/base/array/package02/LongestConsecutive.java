package com.pandy.base.array.package02;

import java.util.HashSet;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 最长连续子序列
 * 意思就是在数值上是连续的序列
 **/
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
        }
        int ans = 0;
        for (int i : hashSet) {
            int cur = 0;
            // 不包含i-1 说明i是一个连续子序列的起始元素
            if (!hashSet.contains(i - 1)) {
                // 发现起始元素的时候 进入一个循环 判断这个子序列的最长长度
                while (hashSet.contains(i)) {
                    cur++;
                    i++;
                }
                ans = Math.max(cur, ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = LongestConsecutive.longestConsecutive(new int[]{200, 1, 300, 4, 2, 3});
        System.out.println(i);
    }
}
