package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/7/3
 *
 * 按照深度优先的顺序，我们记录每个节点的 position 。对于每一个深度，
 * 第一个到达的位置会被记录在 left[depth] 中。
 *
 * 然后对于每一个节点，它对应这一层的可能宽度是 pos - left[depth] + 1 。
 * 我们将每一层这些可能的宽度去一个最大值就是答案。
 *
 **/
public class WidthOfBinaryTree {

    int ans;
    Map<Integer, Integer> left;

    public int width(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x -> pos);
        ans = Math.max(ans , pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
