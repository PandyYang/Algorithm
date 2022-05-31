package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: Pandy
 * @create: 2022/5/6
 * 
 * 二叉树的右视图
 **/
public class RightSideView {


    List<Integer> res = new ArrayList<>();

    /**
     * BFS 利用广度优先搜索进行层次遍历，只记录下每层的最后一个元素。
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }

                if (i == size - 1) {
                    res.add(node.val);
                }
            }
        }
        return res;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;

        dfs(root.right, depth);
        dfs(root.left, depth);
    }

}
