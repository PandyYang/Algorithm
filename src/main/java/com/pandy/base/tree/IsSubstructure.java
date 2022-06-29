package com.pandy.base.tree;

import com.pandy.common.TreeNode;

/**
 * @author: Pandy
 * @create: 2022/3/28
 * <p>
 * 树的子结构
 **/
public class IsSubstructure {

    public boolean isSubstructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        // dfs 当前节点B是否为A的子树
        // 如果不是,同理判断当前节点的孩子节点
        return dfs(A, B) || isSubstructure(A.left, B)
                || isSubstructure(A.right, B);

    }

    public boolean dfs(TreeNode A, TreeNode B) {
        // 比较孩子节点时 B可以为空 例如[1]是[5][1]的子树
        if (B == null) return true;
        // A为空 B不为空 B一定不是A的子树
        if (A == null) return false;
        // 若两个节点的值不同 则B不可能是A的子树 相同则比较两个节点的孩子节点是否相同
        return A.val == B.val && dfs(A.left, B.left) && dfs(A.right, B.right);
    }
}
