package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public static List<List<Integer>> permute(int[] nums) {
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

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(permute.toArray()));
    }
}
