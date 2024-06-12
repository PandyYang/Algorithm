package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.List;

public class A39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(res, candidates, target, list, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, List<Integer> list, int index) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            dfs(res, candidates, target - candidates[i], list, i);
            list.remove(list.size() - 1);
        }
    }
}
