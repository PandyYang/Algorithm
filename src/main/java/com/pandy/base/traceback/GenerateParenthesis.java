package com.pandy.base.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/24
 *
 * 括号的组合
 **/
public class GenerateParenthesis {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, n, "");
        return res;
    }

    private void dfs(int left, int right, String curStr) {
        if (left == 0 && right == 0) {
            res.add(curStr);
            return;
        }

        if (left > 0) {
            System.out.println("left +++++++" + left);
            dfs(left-1, right, curStr + "(");
            System.out.println("left -------" + left);
        }

        if (right > left) {
            System.out.println("left++++++++++++++++++++++++++++++++++++++++++" + left);
            System.out.println("right++++++++++++++++++++++++++++++++++++++++++" + right);
            dfs(left, right-1, curStr + ")");
            System.out.println("left-------------------------------------------" + left);
            System.out.println("right------------------------------------------" + right);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> strings = generateParenthesis.generateParenthesis(3);
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}
