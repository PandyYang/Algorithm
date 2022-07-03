package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/7/3
 **/
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return check(left.left, right.right) && check(left.right, right.left);
    }
}
