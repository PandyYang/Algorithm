package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 二叉树展开为链表
 **/
public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        flatten(right);
        root.right = right;
    }
}
