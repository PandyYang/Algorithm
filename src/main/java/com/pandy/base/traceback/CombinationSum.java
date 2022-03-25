package com.pandy.base.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Pandy
 * @create: 2022/3/24
 * 组合总和
 *
 * 寻找可行性的解都可以使用 搜索回溯 的方法进行解决
 **/
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans.stream().distinct().collect(Collectors.toList());
    }


    /**
     *
     * @param candidates 传入的搜索数组
     * @param target 还剩下的组合
     * @param ans 用来收集组合的数组
     * @param combine 已经组合的列表
     * @param idx 第idx位
     *
     * 递归的中止条件:
     *            1.target <= 0或 candidates被用完,那么在当前的函数中，每次我们可以选择跳过不用第 idx 个数，
     *              即执行 dfs(target, combine, idx + 1)。
     *            2.也可以选择使用第 idx 个数，即执行 dfs(target - candidates[idx], combine, idx)，
     * 注意到每个数字可以被无限制重复选取，因此搜索的下标仍为 idx
     *
     */
    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if (idx == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(combine));
        }

        // 选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }

        // 直接跳过
        dfs(candidates, target, ans, combine, idx + 1);
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.println("list = " + list);
        }
    }
}
