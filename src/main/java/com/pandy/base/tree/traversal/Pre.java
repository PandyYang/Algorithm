package com.pandy.base.tree.traversal;

import com.pandy.common.TreeNode;

import java.util.LinkedList;

/**
 * @author Pandy
 * @date 2/4/2022
 */
public class Pre {

    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    // 非递归版本
    public void preOrderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.println(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }
}
