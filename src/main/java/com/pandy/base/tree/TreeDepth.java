package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Pandy
 * @create: 2022/1/15
 * <p>
 * 二叉树的深度
 **/
public class TreeDepth {

    public int TreeDepth(TreeNode root) {
        int[] max = {0};
        depth(root, max, 1);
        return max[0];
    }

    private void depth(TreeNode root, int[] max, int curDepth) {
        if (root == null) return;
        if (curDepth > max[0]) max[0] = curDepth;
        depth(root.left, max, curDepth + 1);
        depth(root.right, max, curDepth + 1);
    }

    /**
     * 二叉树的最大深度 二叉树的深度为根节点到最远子节点的最长路径上的节点数
     *
     * @param root
     * @return
     */
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int res = 0;
        // 按层扩展
        while (!queue.isEmpty()) {
            // 拿出该层所有节点，并压入子节点
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size -= 1;
            }
            // 统计层数
            res += 1;
        }
        return res;
    }
}
