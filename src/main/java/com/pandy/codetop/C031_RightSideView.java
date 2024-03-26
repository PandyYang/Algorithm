package com.pandy.codetop;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class C031_RightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Integer rightMostValue = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                // 每次更新到最右侧的节点
                rightMostValue = currentNode.val;

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            res.add(rightMostValue);
        }
        return res;
    }
}
