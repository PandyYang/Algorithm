package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.*;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * z字形遍历
 **/
public class ZigzagLevelOrder {

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
        ZigzagLevelOrder zigzagLevelOrder = new ZigzagLevelOrder();
        List<List<Integer>> lists = zigzagLevelOrder.zigzagLevelOrder(node1);
        lists.forEach(System.out::println);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> res2 = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 3, 9 20, 15 7

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();

            // 当前层节点的个数
            int currentLevelSize = queue.size(); // 1 2

            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level); // [[3], [9, 20], [15, 7]]
        }

        for (int i = 0; i < res.size(); i++) {
            if ((i & 1) == 0) {
                res2.add(res.get(i));
            } else {
                List<Integer> list = res.get(i);
                Collections.reverse(list);
                res2.add(list);
            }
        }

        return res2;
    }
}
