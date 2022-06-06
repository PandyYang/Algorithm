package com.pandy.base.stack_queue;

import java.util.Stack;

/**
 * @author Pandy
 * @date 6/1/2022
 *
 * 使用两个栈实现队列
 * 模拟栈的弹出，压入操作。
 */
public class TwoStackToList {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public int push(int val) {
        stack1.push(val);
        return val;
    }

    public int pop() throws Exception {

        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new Exception("stask1 and stask2 are both empty");
        }

        if (!stack2.isEmpty()) {
            return stack2.pop();
        } else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
