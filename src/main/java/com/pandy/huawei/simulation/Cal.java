package com.pandy.huawei.simulation;

import java.util.Stack;

public class Cal {

    public int cal(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;

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
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        if (number != 0) {
            result += sign * number;
        }
        return result;
    }

    public static void main(String[] args) {
        Cal cal = new Cal();
        int cal1 = cal.cal("1+(3-1)");
        System.out.println("cal1 = " + cal1);
    }
}
