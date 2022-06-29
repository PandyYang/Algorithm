package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/2/26
 * <p>
 * 给定一个二叉树，检查它是否是镜像对称。
 * 加入左子树和右子树都为null 返回true
 * 左右子树的val不相等，return false
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return check(left.left, right.right) && check(left.right, right.left);
    }
}
