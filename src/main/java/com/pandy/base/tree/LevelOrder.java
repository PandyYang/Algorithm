package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Pandy
 * @Date 2021/7/31 14:54
 * <p>
 * 使用广度优先遍历解决树的层次遍历问题
 * <p>
 * DFS 深度优先搜索
 * void dfs(TreeNode root) {
 * if (root == null) {
 * return;
 * }
 * dfs(root.left);
 * dfs(root.right);
 * }
 * <p>
 * <p>
 * <p>
 * BFS 广度优先搜索 层次遍历 最短路径
 * <p>
 * void bfs(TreeNode root) {
 * Queue<TreeNode> queue = new ArrayDeque<>();
 * queue.add(root);
 * while (!queue.isEmpty()) {
 * TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
 * if (node.left != null) {
 * queue.add(node.left);
 * }
 * if (node.right != null) {
 * queue.add(node.right);
 * }
 * }
 * }
 * <p>
 * <p>
 * <p>
 * 二叉树的层序遍历
 * 使用队列实现
 */
public class LevelOrder {
    public static ArrayList<ArrayList<Integer>> levelOrder1(TreeNode root) {
        // 创建一个二位数组
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        // 创建队列将根节点放入队列 根节点是单独的一层
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 创建收集每一层的元素的列表
            ArrayList<Integer> level = new ArrayList<Integer>();
            int levelNum = queue.size();
            // 记录这一层中的节点数量n
            for (int i = 0; i < levelNum; i++) {
                level.add(queue.poll().val);
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
            }
            res.add(level);
        }
        return res;
    }
}
