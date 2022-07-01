package com.pandy.base.tree.traversal;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Pandy
 * @date 2/4/2022
 */
public class Post {
    /**
     * 非递归法
     */
    List<Integer> ret = new ArrayList<>();

    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return ret;
        }

        Stack<TreeNode> stack = new Stack<>();
        // 当前正在访问的节点
        TreeNode cur = root;
        // 最近一次访问结束的节点
        TreeNode prev = null;

        while (cur != null || !stack.isEmpty()) {

            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 此时走到最左侧节点，但不能访问根节点
            cur = stack.pop();
            // 要判断右节点是否为空，或右节点已经访问
            if (cur.right == null || cur.right == prev) {
                ret.add(cur.val);
                prev = cur; // 更新prev的指向
                cur = null; // 再从栈顶去元素遍历
            } else {
                stack.push(cur);
                cur = cur.right; // 接着向右节点走
            }
        }

        return ret;
    }
}
