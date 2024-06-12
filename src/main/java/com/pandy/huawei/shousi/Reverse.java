package com.pandy.huawei.shousi;

import java.util.Stack;

public class Reverse {
    public static String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 将当前的字符串推入栈并开始一个新的子字符串
                stack.push(current);
                current = new StringBuilder();
            } else if (c == ')') {
                // 将当前字符串反转并与栈顶字符串拼接
                current.reverse();
                current = stack.pop().append(current);
            } else {
                // 普通字符追加到当前字符串
                current.append(c);
            }
        }

        return current.toString();
    }

    public static void main(String[] args) {
        String s = reverseParentheses("(12(45)3)");
        System.out.println("s = " + s);
    }
}
