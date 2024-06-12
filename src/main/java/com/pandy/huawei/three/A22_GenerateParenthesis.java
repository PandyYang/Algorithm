package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.List;

public class A22_GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, res, 0, 0,  "");
        return  res;
    }

    private void dfs(int n, List<String> res, int left, int right, String s) {

        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (left < n) {
            dfs(n, res, left + 1, right, s + "(");
        }

        if (right < left) {
            dfs(n, res, left, right + 1, s + ")");
        }
    }
}
