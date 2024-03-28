package com.pandy.codetop;

import java.util.ArrayList;
import java.util.List;

public class C040_GenerateParenthesis {
    List<String> res= new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", n, 0, 0);
        return res;
    }

    public void dfs(String ans, int n, int open, int close) {
        if(close > open || open > n) return;
        if(open == n && close == n) res.add(ans);
        dfs(ans + '(', n, open + 1, close);
        dfs(ans + ')', n, open, close + 1);
    }

    public static void main(String[] args) {
        C040_GenerateParenthesis solution = new C040_GenerateParenthesis();
        List<String> result = solution.generateParenthesis(3);
        System.out.println(result);
    }
}
