package com.pandy.codetop;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 */
public class C019_Permute {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
//        ArrayList<Integer> arr = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        dfs(res, nums, queue);
        return res;
    }


    public void dfs(List<List<Integer>> res, int[] nums, List<Integer> queue) {

        if (queue.size() == nums.length) {
            res.add(new ArrayList<>(queue));
            return;
        }

        for (int num : nums) {
            if (queue.contains(num)) continue; // 路径中存在的元素 跳过
            queue.add(num);
            dfs(res, nums, queue);
            queue.remove(queue.size() - 1); // 移除最后一个元素 进行回溯
        }
    }

    public static void main(String[] args) {
        C019_Permute c019 = new C019_Permute();
        List<List<Integer>> permute = c019.permute(new int[]{1, 2, 3});
        permute.forEach(System.out::println);
    }
}
