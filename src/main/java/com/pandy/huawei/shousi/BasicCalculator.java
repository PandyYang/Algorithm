package com.pandy.huawei.shousi;

import java.util.Stack;

public class BasicCalculator {

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1; // 1 表示正，-1 表示负

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                // 将当前结果和符号压入栈中，以便稍后在括号结束时恢复
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop(); // 弹出符号
                result += stack.pop(); // 弹出之前的结果
            }
        }
        
        if (number != 0) {
            result += sign * number;
        }

        return result;
    }

    public static void main(String[] args) {
        BasicCalculator calculator = new BasicCalculator();
        String expression = "1 + 1";
        System.out.println(calculator.calculate(expression)); // 输出：2

        expression = " 2-1 + 2 ";
        System.out.println(calculator.calculate(expression)); // 输出：3

        expression = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculator.calculate(expression)); // 输出：23
    }
}
