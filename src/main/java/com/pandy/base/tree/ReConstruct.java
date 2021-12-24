package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.Arrays;

/**
 * @author Pandy
 * @date 20/12/2021
 * 重建二叉树
 */
public class ReConstruct {
    private static TreeNode reConstructBinaryTree(int []pre, int []in) {
        if (pre == null || in == null) return null;
        if (pre.length == 0 || in.length == 0) return null;
        if (pre.length != in.length) return null;
        // 前序遍历的第一个节点为根节点
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            // 找出中序遍历根节点的位置
            // 中序遍历的左边 都是根节点的左边
            // 中序遍历的右边 都是根节点的右边
            if (pre[0] == in[i]) {
                // 找到左子树
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1),
                        Arrays.copyOfRange(in,0, i));
                // 找到右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i+1, in.length));
            }
        }
        return root;
    }
}
