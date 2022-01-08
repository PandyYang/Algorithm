package com.pandy.base.tree;

import com.pandy.common.ListNode;
import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/1/9
 * 求二叉树的镜像
 **/
public class Mirror {
    private static void mirror(TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) return;
        // 交换
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归
        mirror(root.left);
        mirror(root.right);
    }
}
