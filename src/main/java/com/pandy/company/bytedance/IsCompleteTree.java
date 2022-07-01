package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 完全二叉树的检验
 *
 * 给定一个二叉树的root，确定它是否是一个完全二叉树。
 *
 * 在一个完全二叉树中，除了最后一个关卡外，所有关卡都是完全被填满的，
 * 并且最后一个关卡中的所有节点都是尽可能靠左的。它可以包含1到2h节点之间的最后一级 h。
 **/
public class IsCompleteTree {

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;

        boolean flag = false;

        while (!queue.isEmpty()) {
            temp = queue.remove();

            if (temp == null){
                flag = true;
                continue;
            }

            if (flag) return false;

            queue.add(temp.left);
            queue.add(temp.right);
        }
        return true;
    }
}
