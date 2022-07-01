package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 路径总和
 *
 * 树的根节点到叶子结点，的所有相加等于某值得路径。
 *
 * 我们可以采用深度优先搜索的方式，枚举每一条从根节点到叶子节点的路径。
 * 当我们遍历到叶子节点，且此时路径和恰为目标和时，我们就找到了一条满足条件的路径。
 **/
public class PathSum {

    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    private void dfs(TreeNode root, int targetSum) {

        if (root == null) return;

        path.offerLast(root.val);
        targetSum -= root.val;

        // 边界条件收集  减到最后的叶子结点刚好是0 证明这条路径和为targetsum
        if (root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }

        // 递归条件
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        // 重新放入元素
        path.pollLast();
    }
}
