package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author Pandy
 * @date 19/4/2022
 * 
 * 二叉搜索树 找到树中第k小的节点
 */
public class kthSmallest {

    public int kth(TreeNode root, int k) {
        int leftN = findChild(root.left);
        if (leftN + 1 == k) {
            return root.val;
        } else if (k <= leftN) {
            return kth(root.left, k);
        } else {
            return kth(root.right, k - leftN - 1);
        }
    }

    /**
     * 查找子节点的个数
     *
     * @param root
     * @return
     */
    public int findChild(TreeNode root) {
        if (root == null) return 0;
        return findChild(root.left) + findChild(root.right) + 1;
    }
}
