package com.pandy.base.traceback;

import java.util.*;

/**
 * 全排列II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 */

class PermuteUnique {

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        List<List<Integer>> lists = permuteUnique.permuteUnique(new int[]{1, 2, 3});
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] exist = new boolean[nums.length];
        dfs(res, path, exist, 0, nums);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> path, boolean[] exist, int index, int[] nums) {
        if (index == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (exist[i] || (i > 0 && nums[i] == nums[i - 1] && !exist[i - 1])) {
                continue;
            }

            // 先要加进来 然后将对应索引置为true
            path.addLast(nums[i]);
            exist[i] = true;

            dfs(res, path, exist, index + 1, nums);

            path.removeLast();
            exist[i] = false;
        }
    }
}
