package com.pandy.huawei.three;

import java.util.Deque;
import java.util.LinkedList;

public class A394_DecodeString {

    public String decodeString(String s) {
        Deque<Integer> stack_digit = new LinkedList<>();
        Deque<StringBuilder> stack_string = new LinkedList<>();
        int digit = 0;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '[') {
                stack_digit.push(digit);
                stack_string.push(res);
                digit = 0;
                res = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder temp = stack_string.poll();
                Integer count = stack_digit.poll();
                for (int j = 0; j < count; j++) {
                    temp.append(res.toString());
                }
                res = temp;
            } else if (Character.isDigit(ch)) {
                digit = digit * 10 + ch - '0';
            } else {
                res.append(ch);
            }
        }
        return res.toString();
    }

    private int index = 0;
    public String decodeString2(String s) {
        StringBuilder result = new StringBuilder();
        int num = 0;

        while (index < s.length()) {
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) {
                 num = num * 10 + ch - '0';
                 index++;
            } else if (ch == '[') {
                index++;
                String innder = decodeString2(s);
                for (int i = 0; i < num; i++) {
                    result.append(innder);
                }
                num = 0;
            } else if (ch == ']') {
                index++;
                return result.toString();
            } else {
                result.append(ch);
                index++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = new A394_DecodeString().decodeString2("3[a2[c]]");
        System.out.println("s = " + s);
    }
}
