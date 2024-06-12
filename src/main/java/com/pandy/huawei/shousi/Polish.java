package com.pandy.huawei.shousi;

import java.util.Stack;

// 逆波兰表达式
public class Polish {
    public static int evalRPN(String[] tokens) throws Exception {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)){
                int b = stack.pop();
                int a = stack.pop();
                int res = applyOperator(a, b, token);
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int applyOperator(int a, int b, String operator) throws Exception {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                throw new Exception("not support!");
        }
    }
}
