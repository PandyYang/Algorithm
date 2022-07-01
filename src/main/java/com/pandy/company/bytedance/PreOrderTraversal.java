package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 二叉树的前序遍历
 **/
public class PreOrderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        pre(root, res);
        return res;
    }

    private void pre(TreeNode root, List<Integer> res) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                res.add(root.val);
                stack.add(root);
                // 一直一个节点的左边
                root = root.left;
            }
            // 左边没有了，再弹出右边
            // 弹出的顺序 也是按照根左右遍历
            root = stack.pop().right;
        }
    }
}
