package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.Arrays;

/**
 * @author Pandy
 * @date 20/12/2021
 * 重建二叉树
 * <p>
 * 题目：
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中
 * 都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并 返回。
 * <p>
 * 思路：
 * 思想就是根据前序遍历的第一个节点是跟节点，找到中序遍历此节点的位置，
 * 左边就是左子树，右边就是右子树，然后递归重建。
 */
public class BuildTree {
    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
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
                        Arrays.copyOfRange(in, 0, i));
                // 找到右子树
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length));
            }
        }
        return root;
    }
}
