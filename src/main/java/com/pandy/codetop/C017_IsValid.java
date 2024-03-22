package com.pandy.codetop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class C017_IsValid {
    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = isValid("()");
        System.out.println("valid = " + valid);
    }
}
