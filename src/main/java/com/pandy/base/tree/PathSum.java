package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/28
 * 二叉树中和为某一值的路径
 * <p>
 * 深度优先搜索 dfs
 **/
public class PathSum {

    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target);
        return ret;
    }

    public void dfs(TreeNode root, int target) {
        if (root == null) {
            return;
        }

        path.addLast(root.val);
        target -= root.val;
        if (root.left == null && root.right == null && target == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, target);
        dfs(root.right, target);
        path.pollLast();
    }
}
