package com.pandy.base.stack;

import java.util.Stack;

/**
 * 判断括号的合法性
 *
 * 思路：
 * 首先从左至右遍历一次字符串，将括号的左半部分全部按顺序入栈。
 * 之后如果不为左半部分，则弹栈对比。
 * （【「           」】）
 * 因为按照栈的先入后出，刚好遍历到的值可以弹出直接对比。
 * 最后遍历完成，栈必须为空。
 *  「  ------- 」
 */
public class IsValid {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            //未完成之前栈不能为空 并且弹出的元素要和c相等 否则直接为false
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        // 最后判断不多不少
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }
}
