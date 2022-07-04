package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * 求根节点到叶节点数字之和
 * <p>
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * <p>
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * <p>
 * 我发现要多条件组合的问题，没处下手的问题，准备暴力的问题，都想想回溯吧。
 **/
public class SumNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum) {
        if (root == null) return 0;

        int sum = preSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
