package com.pandy.codetop;

import com.pandy.common.TreeNode;

import java.util.*;

/**
 * 用一个队列收集每层的root数据，并保存其左右节点数据作为下一次遍历对象。
 * 注意一般使用 offer 和 poll
 * 而不是 add 和 remove
 * 因为前者在不满足情况的条件下会返回false
 * 后者直接报错
 */
public class C012_LevelOrder {
    // bfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 每一层的元素
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                // 删除队头第一个元素
                root = queue.remove();
                level.add(root.val);
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            res.add(level);
        }
        return res;
    }
}
