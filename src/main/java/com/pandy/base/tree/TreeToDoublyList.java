package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pandy
 * @date 29/3/2022
 * <p>
 * 将二叉搜索树转换为双向循环链表
 */
public class TreeToDoublyList {
    private final List<TreeNode> list = new ArrayList<>();

    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        // 中序遍历
        mid(root);
        // 头结点
        TreeNode p = list.get(0);
        TreeNode head = p;
        // 组装链表
        for (int i = 1; i < list.size(); i++) {
            TreeNode q = list.get(i);
            p.right = q;
            q.left = p;
            p = q;
        }

        // 组装头结点
        p.right = head;
        head.left = p;
        return head;
    }

    public void mid(TreeNode root) {
        if (root == null) return;
        mid(root.left);
        list.add(root);
        mid(root.right);
    }
}
