package com.pandy.company.bytedance;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/3
 * <p>
 * 二叉树展开为链表
 * <p>
 * 将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序。
 * 因此，可以对二叉树进行前序遍历，获得各节点被访问到的顺序。
 * 由于将二叉树展开为链表之后会破坏二叉树的结构，因此在前序遍历结束之后更新每个节
 * 点的左右子节点的信息，将二叉树展开为单链表。
 **/
public class Flatten {

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preOrderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrderTraversal(root.left, list);
            preOrderTraversal(root.right, list);
        }
    }
}
