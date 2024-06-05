package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringDFS {

    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> zuhe(String s) {
        dfs(res, s, 0, new ArrayList<String>());
        return res;
    }

    private static void dfs(List<List<String>> res, String s, int index, ArrayList<String> list) {
        if (index == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String ss = s.substring(index, i + 1);
            list.add(ss);
            dfs(res, s, index + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<String>> abc = StringDFS.zuhe("abc");
        String string = Arrays.toString(abc.toArray());
        System.out.println("string = " + string);
    }
}
