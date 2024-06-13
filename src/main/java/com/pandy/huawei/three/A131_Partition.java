package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class A131_Partition {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, s, 0, new ArrayList<String>());
        return res;
    }

    private void dfs(List<List<String>> res, String s, int index, ArrayList<String> list) {

        if (index == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String palin = s.substring(index, i + 1);
            if (!isPalin(palin, 0, palin.length() - 1)) {
                return;
            }

            list.add(palin);
            dfs(res, s, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    private boolean isPalin(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
