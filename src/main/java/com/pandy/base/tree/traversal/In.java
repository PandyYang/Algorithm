package com.pandy.base.tree.traversal;

import com.pandy.common.TreeNode;

import java.util.LinkedList;

/**
 * @author Pandy
 * @date 2/4/2022
 */
public class In {

    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.val);
            inOrderTraversal(root.right);
        }
    }

    public void inOrderTraversal2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;

        while (pNode != null || !stack.isEmpty()) {

            if (pNode != null) {
                stack.push(pNode);
                // 一直压左边
                pNode = pNode.left;
            } else {
                // 到头了 边弹出 边走右边
                TreeNode node = stack.pop();
                System.out.println(node.val);
                pNode = pNode.right;
            }
        }
    }
}
