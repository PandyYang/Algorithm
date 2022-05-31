package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @Author Pandy
 * @Date 2021/7/31 18:26
 * 找出两个二叉树节点的最近公共祖先
 */
public class LowestCommonAncestor {

    public static int low(TreeNode root, int o1, int o2) {
        return commonAncestor(root, o1, o2).val;
    }

    public static TreeNode commonAncestor(TreeNode root, int o1, int o2) {
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }

        TreeNode left = commonAncestor(root.left, o1, o2); // 返回左侧的p\q节点
        TreeNode right = commonAncestor(root.right, o1, o2); // 返回右侧的p\q节点

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = binaryTree.createBinaryTree(new int[]{3, 5, 1, 6, 2, 0, 8, 0, 0, 7, 4}, 0);
        System.out.println(low(root, 5, 1));
    }

    /**
     * 所有的递归返回值有4种情况 null p q 公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 遍历到叶节点就会返回null
        if (root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else return right;
    }
}
