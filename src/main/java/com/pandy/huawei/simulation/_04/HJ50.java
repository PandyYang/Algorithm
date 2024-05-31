package com.pandy.huawei.simulation._04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ50 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            // 初始化，将"{}""[]"替换为"()"
            str = str.replace("[", "(")
                    .replace("{", "(")
                    .replace("]", ")")
                    .replace("}", ")");
            System.out.println(culSuffix(infixToSuffix(str)));
        }
    }

    // 中缀表达式 转 后缀表达式
    public static List<String> infixToSuffix(String str) {
        // 存储后缀表达式
        List<String> result = new ArrayList<>();
        // 存储操作符和括号的栈
        Stack<Character> operateStack = new Stack<>();
        // 可能的负数开头和括号后的负数
        boolean flag = true;
        // 用来累积多位数字
        String temp = "";

        for (char c : str.toCharArray()) {
            // 负数开头处理（补零）
            if (flag && c == '-') {
                result.add("0");
            }
            flag = false;
            // 多位数处理
            if (c >= '0' && c <= '9') {
                temp += c;
                continue;
            }
            // 数字入栈（集合）
            if (temp.length() > 0) {
                result.add(temp);
                temp = "";
            }
            // 符号入栈（集合）
            if (operateStack.empty() || operateStack.peek() == '(') {
                operateStack.push(c);
            } else if (c == '(') {
                operateStack.push(c);
                flag = true;
            } else if (c == ')'){
                while (operateStack.peek() != '(') {
                    result.add(operateStack.pop() + "");
                }
                operateStack.pop();
            } else {
                while (!operateStack.empty()
                        && operateStack.peek() != '('
                        && getPriority(c) <= getPriority(operateStack.peek())) {
                    result.add(operateStack.pop() + "");
                }
                operateStack.push(c);
            }
        }
        // 后续处理
        if (temp.length() > 0) {
            result.add(temp);
        }
        while (!operateStack.empty()) {
            result.add(operateStack.pop() + "");
        }
        return result;
    }

    // 获取操作符优先级
    public static int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '*' || c == '/') {
            return 2;
        }
        throw new RuntimeException("异常操作符！");
    }

    // 计算后缀表达式
    public static int culSuffix(List<String> list) {
        Stack<Integer> numStack = new Stack<>();
        Integer temp = null;
        for (String item : list) {
            switch (item) {
                case "+" :
                case "-" :
                case "*" :
                case "/" :
                    temp = cul(numStack.pop(), numStack.pop(), item);
                    numStack.push(temp);
                    break;
                default :
                    numStack.push(Integer.parseInt(item));
            }
        }
        return numStack.peek();
    }

    // 计算加 减 乘 除
    public static int cul(int num1, int num2, String operate) {
        switch (operate) {
            case "+" :
                return num2 + num1;
            case "-" :
                return num2 - num1;
            case "*" :
                return num2 * num1;
            case "/" :
                return num2 / num1;
        }
        throw new RuntimeException("异常数据，计算失败！");
    }
}