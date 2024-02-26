package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author Pandy
 * @date 19/4/2022
 * <p>
 * 二叉搜索树 找到树中第k小的节点
 * 使用中序遍历，中序遍历从小到大，第k小，就是遍历到的第k个值。
 */
public class kthSmallest {
    int res = 0;
    int rank = 0;

    void traverse(TreeNode root, int k) {
        if(root == null) {
            return;
        }
        traverse(root.left, k);

        rank ++;
        if(rank == k) {
            res = root.val;
            return;
        }

        traverse(root.right, k);
    }
}