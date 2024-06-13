package com.pandy.huawei.three;

import java.util.Stack;

public class A402_RemoveKdigits {
    public String removeKdigits(String nums, int k) {
        if (nums.length() == k) return "0";

        Stack<Character> stack = new Stack<>();
        for (char c : nums.toCharArray()) {
            while(!stack.isEmpty() && stack.peek() > c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        StringBuilder reverse = stringBuilder.reverse();

        while (reverse.length() > 1 && reverse.charAt(0) == '0') {
            reverse.deleteCharAt(0);
        }

        return reverse.toString();
    }

    public static void main(String[] args) {
        String s = new A402_RemoveKdigits().removeKdigits("1234567890", 9);
        System.out.println("s = " + s);
    }
}
