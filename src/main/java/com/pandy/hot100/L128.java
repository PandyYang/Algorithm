package com.pandy.hot100;

import java.util.HashSet;

/***
 *
 * 最长连续序列
 *
 * HashSet numSet：此集合存储所有数字，允许常数时间复杂度的查找。
 * 外层 For 循环：遍历集合中的每个数字。
 * 序列起点检查：如果 num - 1 不在集合中，则 num 是新序列的起始数字。
 * 内层 While 循环：从 num 开始计算序列长度。
 * 最长序列长度更新：更新发现的最长序列长度。
 */
public class L128 {

    public static void main(String[] args) {
        L128 l128 = new L128();
        int i = l128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println("i = " + i);
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (Integer num : set) {
            if(!set.contains(num - 1)) {
                int cur = num;
                int count = 1;
                while (set.contains(cur + 1)) {
                    cur += 1;
                    count += 1;
                }
                max = Math.max(max, count);
            }
        }
        return max;

//        for (int i = 0; i < nums.length; i++) {
//            int count = 0;
//            int n = nums[i];
//            while (set.contains(n)) {
//                count ++;
//                n--;
//            }
//            max = Math.max(count, max);
//        }
//        return max;
    }
}
