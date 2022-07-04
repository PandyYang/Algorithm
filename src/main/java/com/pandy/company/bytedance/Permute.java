package com.pandy.company.bytedance;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/2
 * <p>
 * 全排列
 **/
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();

        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, res, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
