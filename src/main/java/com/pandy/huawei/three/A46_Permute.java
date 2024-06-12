package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列
 */
public class A46_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited) {
        if (nums.length == list.size()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(res, nums, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
