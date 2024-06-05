package com.pandy.huawei.shousi;

import java.util.Deque;
import java.util.LinkedList;

public class SimplyPath {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> queue = new LinkedList<>();
        for (String name : names) {
            if (name.equals("..")) {
                queue.pollLast();
            } else if (!".".equals(name) && !name.isEmpty()) {
                queue.add(name);
            }
        }

        if (queue.isEmpty()) {
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!queue.isEmpty()) {
            stringBuilder.append("/").append(queue.pollFirst());
        }
        return stringBuilder.toString();

    }
}
