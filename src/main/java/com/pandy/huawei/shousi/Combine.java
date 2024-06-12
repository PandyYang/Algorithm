package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combine {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new ArrayList<Integer>(), new boolean[k]);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int n, int k, int index, ArrayList<Integer> list, boolean[] visited) {

        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            dfs(res, n, k, i + 1,  list, visited);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
//        List<List<Integer>> combine = combine(1, 1);
        List<List<Integer>> combine = combine(4, 2);
        System.out.println(Arrays.toString(combine.toArray()));
    }
}
