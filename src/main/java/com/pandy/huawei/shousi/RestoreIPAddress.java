package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RestoreIPAddress {

    private List<String> result;

    private LinkedList<String> path;

    public List<String> restoreIpAddresses(String s) {
        this.result = new ArrayList<>();
        this.path = new LinkedList<>();

        backTracking(s, 0);

        return result;
    }

    private void backTracking(String s, int start) {

        // 有4段 且s全部用完
        if (path.size() == 4 && start == s.length()) {
            result.add(String.join(".", path));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);

            // 前导为 0 直接跳过
            if (s.charAt(start) == '0' && cur.length() > 1) {
                continue;
            }

            if (cur.length() > 3 || Integer.parseInt(cur) > 255) {
                continue;
            }

            path.add(cur);
            backTracking(s, i + 1);
            path.removeLast();
        }
    }
}
