package com.pandy.base.tree;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/3/28
 **/
public class verifyPostOrder {

    public boolean verifyPostOrder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                root = stack.pop();
            }
            stack.add(postorder[i]);
        }
        return true;
    }
}
