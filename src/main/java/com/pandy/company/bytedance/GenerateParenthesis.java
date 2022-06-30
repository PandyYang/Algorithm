package com.pandy.company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/6/30
 *
 * 括号生成
 *
 * 数字 n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 **/
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrace(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    private void backtrace(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        if (open < max) {
            cur.append("(");
            backtrace(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }

        if (close < open) {
            cur.append(")");
            backtrace(ans, cur, open, close +1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(10);
        strings.forEach(System.out::println);
    }
}
