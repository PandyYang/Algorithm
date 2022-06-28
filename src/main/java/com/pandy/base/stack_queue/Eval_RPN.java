package com.pandy.base.stack_queue;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/6/29
 **/
public class Eval_RPN {
    public int evalRPN(String[] tokens) {
        int len = tokens.length;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            if (tokens[i] == "+" || tokens[i] == "-" || tokens[i] == "*" || tokens[i] == "/") {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                if (tokens[i] == "+") {
                    stack.push(String.valueOf(b + a));
                    continue;
                }
                if (tokens[i] == "-") {
                    stack.push(String.valueOf(b - a));
                    continue;
                }
                if (tokens[i] == "*") {
                    stack.push(String.valueOf(b * a));
                    continue;
                }
                if (tokens[i] == "/") {
                    stack.push(String.valueOf(b / a));
                    continue;
                }
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
