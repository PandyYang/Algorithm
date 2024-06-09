package com.pandy.huawei;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else {
                    res = Math.max(res, i-stack.peek());
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int i = longestValidParentheses("(()");
        System.out.println("i = " + i);
    }
}