package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/30
 * <p>
 * 从前序遍历到中序遍历重建二叉树
 **/
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        // 前序遍历  第一个节点即为root节点
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) {
                // 前序 1- i+1  中序 0 - i
                root.left = buildTree(Arrays.copyOfRange(preorder, 1, i + 1), Arrays.copyOfRange(inorder, 0, i));
                // 右边是i + 1, 总长
                root.right = buildTree(Arrays.copyOfRange(preorder, i + 1, preorder.length), Arrays.copyOfRange(inorder, i + 1, inorder.length));
                break;
            }
        }
        return root;
    }
}
