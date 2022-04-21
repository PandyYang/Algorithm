package com.pandy.base.tree;

import com.pandy.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/4/21
 * 二叉树的锯齿形层序遍历
 * 使用dfs，对应层判断一下奇偶，决定在表头还是表尾添加元素就可以了
 **/
public class ZipZagLevelOrder {

    public List<List<Integer>> zipzaglevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        travelsal(root, res, 0);
        return res;
    }


    private void travelsal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) return;

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        if ((level & 1) == 1) {
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }
        travelsal(root.left, res, level + 1);
        travelsal(root.right, res, level + 1);
    }
}
