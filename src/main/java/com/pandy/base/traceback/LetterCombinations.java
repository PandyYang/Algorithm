package com.pandy.base.traceback;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/24
 **/
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        for (int i = 0; i < digits.length(); i++) {
            result = combination(result, str[digits.charAt(i) - '0' - 2]);
        }
        return result;
    }

    public static List<String> combination(List<String> s1, String s2) {
        List<String> str = new ArrayList<>();
        for (int i = 0; i < s2.length(); i++) {
            if (s1.isEmpty()) {
                str.add(s2.substring(i, i + 1));
            } else {
                for (String s : s1) {
                    str.add(s + s2.charAt(i));
                }
            }
        }
        return str;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("33");
        for (String string : strings) {
            System.out.println("string = " + string);
        }
    }
}
