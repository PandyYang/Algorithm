package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列2
 * 所有求不重复的 都排序 且进行条件判断
 */
public class A47_PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;

            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(res, nums, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
