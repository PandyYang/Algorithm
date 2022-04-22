package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/4/5
 *
 * 判断是否为二叉树
 *
 * 记录下每个节点的前一个节点的值 采用中序遍历
 * 若前一个节点的值大于此节点的值
 * 即停止递归 不是二叉树
 **/
public class IsValidBST {

    long pre = Long.MIN_VALUE;
    boolean res = true;

    public boolean isValidBST(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);

        // 记录每次的节点值
        if (pre >= root.val) {
            res = false;
            return;
        } else {
            pre = root.val;
        }

        dfs(root.right);
    }
}
