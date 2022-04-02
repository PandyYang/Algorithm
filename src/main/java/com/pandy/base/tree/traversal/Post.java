package com.pandy.base.tree.traversal;

import com.pandy.common.TreeNode;

/**
 * @author Pandy
 * @date 2/4/2022
 */
public class Post {
    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }
}
