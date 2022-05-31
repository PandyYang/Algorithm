package com.pandy.base.string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Permute {
    /**
     * 使用回溯算法（树的深度优先遍历dfs解决此问题）
     * 状态：
     * 已经选择的 used
     * 当前遍历的层数 depth
     * 收集的元素 res
     * 需要处理的元素 nums
     * 当前数组长度 len
     * 当前已选择的数 path
     */
    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) return res;

        Deque<Integer> path = new ArrayDeque<>();
        Boolean[] used = new Boolean[len];
        dfs(nums, len, 0, path, res, used);
        return res;
    }

    public void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res, Boolean[] used) {
        // 当前的深度已经最深
        if (len == depth) {
            res.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = 0; i < len; i++) {

            if (used[i]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;
            // 进行递归遍历
            dfs(nums, len, depth + 1, path, res, used);
            path.removeLast();
            used[i] = false;
        }
    }
}
