package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/1/23
 * <p>
 * 判断一个二叉树是否为平衡二叉树
 * <p>
 * 思路：根据二叉树的定义，我们可以递归遍历二叉树的每一个节点，求出每个节点的左右子树的高度，如果每个节点的
 * 左右子树的高度差不超过1，按照定义，他就是一颗平衡二叉树。
 **/
public class isBalance {

    private static int helper(TreeNode root) {
        if (root == null) return 0;
        // 左树高度
        int left = helper(root.left);
        // 右树高度
        int right = helper(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return helper(root) != -1;
    }
}
