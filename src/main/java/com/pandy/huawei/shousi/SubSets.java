package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(res, new ArrayList<Integer>(), 0, nums, visited);
        String string = Arrays.toString(res.toArray());
        System.out.println("string = " + string);
        return res;
    }

    private static  void dfs(List<List<Integer>> res, List<Integer> list, int index, int[] nums, boolean[] visited) {

        res.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            List<Integer> newPath = new ArrayList<>(list);
//            list.add(nums[i]);
            newPath.add(nums[i]);
            dfs(res, newPath, i + 1, nums, visited);
//            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSets.subsets(new int[]{1,2,3});
    }
}
