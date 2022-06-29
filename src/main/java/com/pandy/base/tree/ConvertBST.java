package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * BST的中序遍历就是从小到大,那么反过来就是从大到小,然后累加就好了.
 **/
public class ConvertBST {
    int num = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += num;
            num = root.val;
            convertBST(root.left);
            return root;
        }
        return null;
    }
}
