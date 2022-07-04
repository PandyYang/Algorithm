package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * 二叉树的层序遍历
 **/
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
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
        return res;
    }

}
