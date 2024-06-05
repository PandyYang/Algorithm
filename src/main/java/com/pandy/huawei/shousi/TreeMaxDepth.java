package com.pandy.huawei.shousi;

import com.pandy.common.TreeNode;

public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
