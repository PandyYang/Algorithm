package com.pandy.codetop;

import com.pandy.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class C046_BuildTree {
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0; // 初始化先序遍历的索引
        inorderIndexMap = new HashMap<>();
        // 填充中序遍历索引的HashMap，便于快速查找
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // 没有元素构造子树
        if (left > right) return null;

        // 根节点的值是先序遍历数组的第一个元素
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // 构建左右子树
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}
