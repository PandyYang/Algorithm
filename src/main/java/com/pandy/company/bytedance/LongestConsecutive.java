package com.pandy.company.bytedance;

import java.util.HashSet;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 最长连续序列
 **/
public class LongestConsecutive {
    public int longestConsecutive(int[] nums) {
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
        LongestConsecutive l = new LongestConsecutive();
        int i = l.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println("i = " + i);
    }
}
