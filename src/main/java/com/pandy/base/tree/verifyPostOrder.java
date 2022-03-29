package com.pandy.base.tree;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/3/28
 *
 *
 * 翻转先序遍历又是root->right->left的，基于这样的性质和遍历方式，我们知道越往右越大，这样，就可以构造一个单调递增的栈，来记录遍历的元素。
 *
 * 为什么要用单调栈呢，因为往右子树遍历的过程，value是越来越大的，一旦出现了value小于栈顶元素value的时候，就表示要开始进入左子树了（如果不是，就应该继续进入右子树，否则不满足二叉搜索树的定义，不理解的请看下二叉搜索树的定义），但是这个左子树是从哪个节点开始的呢？
 *
 * 单调栈帮我们记录了这些节点，只要栈顶元素还比当前节点大，就表示还是右子树，要移除，因为我们要找到这个左孩子节点直接连接的父节点，也就是找到这个子树的根，只要栈顶元素还大于当前节点，就要一直弹出，直到栈顶元素小于节点，或者栈为空。栈顶的上一个元素就是子树节点的根。
 *
 * 接下来，数组继续往前遍历，之后的左子树的每个节点，都要比子树的根要小，才能满足二叉搜索树，否则就不是二叉搜索树。
 **/
public class verifyPostOrder {

    public static boolean verifyPostOrder(int[] postorder) {
        // 单调栈使用 单调递增的单调栈
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 逆向遍历 就是翻转的先序遍历
        for (int i = postorder.length - 1; i >= 0; i--) {
            // 左子树元素必须要小于递增栈被peek访问的元素 否则就不是二叉搜索树
            if (postorder[i] > root) return false;

            // 栈顶元素比当前大 是右子树 要移除
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                // 数组元素小于单调栈的元素了，表示往左子树走了，记录下上个根节点
                // 找到这个左子树对应的根节点，之前右子树全部弹出，不再记录，因为不可能在往根节点的右子树走了
                root = stack.pop();
            }
            // 新元素入栈
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        boolean b = verifyPostOrder(new int[]{1, 2, 3, 6, 5});
        System.out.println("b = " + b);
    }
}
