package com.pandy.codetop;

import java.util.ArrayList;
import java.util.List;

public class C032_RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrace(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrace(String s, int start, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(",", path));
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            String segment = s.substring(start, i + 1);
            if (isValid(segment)) {
                path.add(segment);
                backtrace(s, i + 1, path, result);
                path.remove(path.size() - 1);
            }
            if (segment.equals("0")) break;
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 3) return false;
        if (segment.startsWith("0") && segment.length() > 1) return false;
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        C032_RestoreIpAddress c032RestoreIpAddress = new C032_RestoreIpAddress();
        List<String> strings = c032RestoreIpAddress.restoreIpAddresses("25525511135");
        strings.forEach(System.out::println);
    }
}
