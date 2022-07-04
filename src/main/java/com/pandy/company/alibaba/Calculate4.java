package com.pandy.company.alibaba;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/7/4
 *
 * 只有加减乘除
 *
 **/
public class Calculate4 {
    private void calculate(Deque<Integer> stack, int sign, int num) {
        if (sign == '+') {
            stack.push(num);
        } else if (sign == '-') {
            stack.push(-num);
        } else if (sign == '*') {
            stack.push(stack.pop() * num);
        } else if (sign == '/') {
            stack.push(stack.pop() / num);
        }
    }

    private int[] solve(String s, int index) {
        Deque<Integer> stack = new LinkedList<>();
        int num = 0;
        char sign = '+';

        while (index < s.length() && s.charAt(index) != ')') {

            if (Character.isDigit(s.charAt(index))) {
                num = num * 10 + s.charAt(index++) - '0';
            } else if (s.charAt(index) == '(') {
                int[] next = solve(s, index + 1);
                index = next[0] + 1;
                num = next[1];
            } else {
                calculate(stack, sign, num);
                num = 0;
                sign = s.charAt(index++);
            }
        }
        calculate(stack, sign, num);
        // 记录当前的索引和计算求和
        return new int[]{index, stack.stream().reduce(0, Integer::sum)};
    }

    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return solve(s, 0)[1];
    }

    public static void main(String[] args) {
        Calculate4 calculate4 = new Calculate4();
        int calculate = calculate4.calculate("1+(9-7)*3/2");
        System.out.println("calculate = " + calculate);
    }
}
