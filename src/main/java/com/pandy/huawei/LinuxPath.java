package com.pandy.huawei;

import java.util.Stack;

public class LinuxPath {
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!part.equals(".") && !part.isEmpty()) {
                stack.push(part);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : stack) {
            stringBuilder.append("/").append(s);
        }

        return stringBuilder.length() > 0 ? stringBuilder.toString() : "/";
    }
}
