package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/1/15
 **/
public class KthNode {

    public TreeNode kth(TreeNode pRoot, int k) {
        TreeNode[] nodes = new TreeNode[1];
        int[] ints = {0};

        kthNode(pRoot, k, nodes, ints);

        return nodes[0];
    }

    private void kthNode(TreeNode root, int k, TreeNode[] res, int[] cursor) {
        if (root == null) return;
        if (res[0] != null) return;

        kthNode(root.left, k, res, cursor);
        cursor[0]++;

        if (cursor[0] == k) {
            res[0] = root;
            return;
        }

        kthNode(root.right, k, res, cursor);
    }
}
