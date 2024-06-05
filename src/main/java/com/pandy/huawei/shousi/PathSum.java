package com.pandy.huawei.shousi;

import com.pandy.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class PathSum {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return res;
    }

    private void dfs(TreeNode root, int targetSum) {

        if (root == null) return;

        path.offerLast(root.val);

        targetSum -= root.val;

        if (root.left == null && root.right == null && targetSum == 0) {
            res.add(new LinkedList<>(path));
        }

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        path.pollLast();
    }
}
