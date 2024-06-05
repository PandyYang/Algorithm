package com.pandy.huawei.shousi;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;

    }

    public void preOrder(TreeNode root, List<Integer> res) {
        if(root == null) {
            return;
        }

        preOrder(root.left, res);
        res.add(root.val);
        preOrder(root.right, res);
    }
}
