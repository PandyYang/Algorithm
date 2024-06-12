package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, new ArrayList<Integer>(), new boolean[nums.length], 0);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] nums, ArrayList<Integer> list, boolean[] visited, int index) {

        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            dfs(res, nums, list, visited, index + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(permute.toArray()));
    }
}