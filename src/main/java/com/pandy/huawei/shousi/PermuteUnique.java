package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, visited, nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, boolean[] visited, int[] nums, int index, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            if (visited[j]) continue;
            if (j > 0 && nums[j] == nums[j - 1] && !visited[j - 1]) continue;

            visited[j] = true;
            list.add(nums[j]);
            dfs(res, visited, nums, index, list);
            visited[j] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {

    }
}
