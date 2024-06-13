package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A93_RestoreIpAddresses {
    private List<String> result = new ArrayList<>();
    private LinkedList<String> path = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrace(s, 0);
        return result;
    }

    private void backtrace(String s, int start) {

        if(path.size() == 4 && start == s.length()) {
            result.add(String.join(".", path));
            return;
        }

        for(int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i+1);
            if(s.charAt(start) == '0' && cur.length() > 1) {
                continue;
            }

            if(cur.length() > 3 || Integer.parseInt(cur) > 255) {
                continue;
            }

            path.add(cur);
            backtrace(s, i + 1);
            path.removeLast();
        }
    }
}
