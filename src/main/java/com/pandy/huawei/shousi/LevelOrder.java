package com.pandy.huawei.shousi;

import com.pandy.common.TreeNode;

import java.util.*;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll();
               list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

               if (node.right != null) {
                   queue.add(node.right);
               }
            }
            res.add(list);
        }
        return res;
    }
}
