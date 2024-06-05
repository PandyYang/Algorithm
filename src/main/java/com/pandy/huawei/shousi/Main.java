package com.pandy.huawei.shousi;

import java.util.*;

/**
 * 使用dfs
 */
public class Main {
    public static List<List<Integer>> zuhe(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        findCombinationsHelper(nums, target, 0, new ArrayList<>(), res);
        return res;
    }

    /**
     *
     * @param nums 原始输入
     * @param target 目标值
     * @param start 搜索起点
     * @param curr 当前路径
     * @param res 结果集
     */
    private static void findCombinationsHelper(int[] nums, int target, int start, ArrayList<Integer> curr, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]); // cur加入这个值 然后每次我们会减去nums[i] 直到target为0,
            findCombinationsHelper(nums, target - nums[i], i + 1, curr, res);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> zuhe = Main.zuhe(new int[]{24}, 24);
        System.out.println(Arrays.toString(zuhe.toArray()));

        List<List<Integer>> zuhe2 = Main.zuhe(new int[]{24, 0}, 24);
        System.out.println(Arrays.toString(zuhe2.toArray()));

        List<List<Integer>> zuhe3 = Main.zuhe(new int[]{25, -1}, 24);
        System.out.println(Arrays.toString(zuhe3.toArray()));

        List<List<Integer>> zuhe4 = Main.zuhe(new int[]{24, 0, 12, 12}, 24);
        System.out.println(Arrays.toString(zuhe4.toArray()));
    }
}
