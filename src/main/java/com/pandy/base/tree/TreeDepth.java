package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/1/15
 *
 * 二叉树的深度
 **/
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        int[] max = {0};
        depth(root, max, 1);
        return max[0];
    }

    private void depth(TreeNode root, int[] max, int curDepth) {
        if (root == null) return;
        if (curDepth > max[0]) max[0] = curDepth;
        depth(root.left, max, curDepth+1);
        depth(root.right, max, curDepth+1);
    }
}
