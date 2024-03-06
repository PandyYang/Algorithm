package com.pandy.classic_150;

import com.pandy.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            List<Integer> level = new ArrayList();

            int size = stack.size();

            for (int i = 0; i < size; i++) {
                root = stack.pollLast();
                level.add(root.val);
                if (root.left != null) stack.push(root.left);
                if (root.right != null) stack.push(root.right);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        List<List<Integer>> lists = Solution.levelOrder(node1);
        lists.forEach(System.out::println);
    }
}
