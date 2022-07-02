package com.pandy.company.bytedance;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/7/2
 **/
public class IsValid {
    public boolean isValid(String s) {
        if (s.length() <= 1) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        boolean valid = isValid.isValid("){");
        System.out.println("valid = " + valid);

    }
}
