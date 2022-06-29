package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/6/29
 **/
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        // 保存右子树 交换节点
        TreeNode rightTree = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(rightTree);
        return root;
    }
}
