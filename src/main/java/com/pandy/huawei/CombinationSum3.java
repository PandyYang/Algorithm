package com.pandy.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, k, 1, res, new ArrayList<Integer>());
        return res;
    }

    private void dfs(int target, int k, int index, List<List<Integer>> res, ArrayList<Integer> list) {
        if (target == 0 && list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = index; i <= 9; i++) {
            list.add(i);
            dfs(target - i, k, i+1, res, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
        List<List<Integer>> lists = c.combinationSum3(3, 9);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
