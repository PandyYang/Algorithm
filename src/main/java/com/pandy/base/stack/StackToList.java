package com.pandy.base.stack;

import java.util.Stack;

/**
 * @author Pandy
 * @date 24/12/2021
 */
public class StackToList {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int a) {
        stack1.push(a);
    }

    public int pop() throws Exception {
        if (stack1.size() == 0 && stack2.size() == 0)
            throw new Exception("stack is empty");
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
