package com.pandy.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrace(candidates, target, 0, new ArrayList<>(), res);
        return res.stream().distinct().collect(Collectors.toList());
    }

    private void backtrace(int[] candidates, int target, int index, ArrayList<Integer> list, List<List<Integer>> res) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrace(candidates, target - candidates[i], i, list, res);
            list.remove(list.size()  - 1);
        }
    }
}
