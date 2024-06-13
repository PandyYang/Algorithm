package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A78_SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, nums, 0, new ArrayList<Integer>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] nums, int index, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            list.add(nums[index]);
            dfs(res, nums, i+1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = new A78_SubSets().subsets(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(subsets.toArray()));
    }
}
