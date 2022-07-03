package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 二叉树的公共祖先
 **/
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || p.val == root.val || q.val == root.val) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}
