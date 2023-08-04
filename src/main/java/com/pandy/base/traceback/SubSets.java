package com.pandy.base.traceback;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/27
 * <p>
 * 求子集
 **/
public class SubSets {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯算法的递归路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 遍历子集问题的回溯树
    void backtrack(int[] nums, int start) {

        // 前序位置 每个节点的值都是一个子集
        res.add(new LinkedList<>(track));
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过start参数控制树枝的遍历 避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        List<List<Integer>> subsets = subSets.subsets(new int[]{1, 2, 3});
        subsets.forEach(System.out::println);
    }
}
