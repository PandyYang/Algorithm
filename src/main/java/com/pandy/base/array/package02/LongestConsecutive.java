package com.pandy.base.array.package02;

import java.util.HashSet;

/**
 * @author: Pandy
 * @create: 2022/6/29
 *
 * 最长连续子序列
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
            if (!hashSet.contains(i - 1)) {
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
