package com.pandy.base.traceback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pandy
 * @date 6/7/2022
 * <p>
 * 子集II
 * <p>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsWithDup {

    public static void main(String[] args) {
        SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
        List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(new int[]{1, 2, 2});
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);      // 排序后便于去重
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }

    // dfs - 递归函数
    public void dfs(List<List<Integer>> res, List<Integer> list, int index, int[] nums) {
        if (index == nums.length) {   // [基本情况] 如果游标到达尾部，将当前list拷贝放入res中
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]);
        dfs(res, list, index + 1, nums); // 选择当前的数

        list.remove(list.size() - 1);   // 回溯 - 将当前添加的数删除
        while (index < nums.length - 1 && nums[index] == nums[index + 1]) { // 去重，不选当前数递归时直接跳过重复数
            index++;    // 所有重复数的可能性在前面递归中均会出现
        }
        dfs(res, list, index + 1, nums); // 不选择当前的数
    }
}
