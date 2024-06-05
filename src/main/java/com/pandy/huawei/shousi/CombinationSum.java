package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<Integer>(), candidates, 0, target);
        return res;
    }

    /**
     *
     * @param res
     * @param list
     * @param candidates
     * @param start
     * @param target
     */
    private static void dfs(List<List<Integer>> res, ArrayList<Integer> list, int[] candidates, int start, int target) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int j = start; j < candidates.length; j++) {
            list.add(candidates[j]);
            dfs(res, list, candidates, j, target - candidates[j]);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = CombinationSum.combinationSum(new int[]{1, 3, 3}, 4);
        String string = Arrays.toString(lists.toArray());
        System.out.println("string = " + string);
    }
}
