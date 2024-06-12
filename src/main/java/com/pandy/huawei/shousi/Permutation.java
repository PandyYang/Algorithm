package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public List<String> permute(String str) {
        List<String> result = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return result;
        }

        boolean[] used = new boolean[str.length()];

        StringBuilder stringBuilder =new StringBuilder();
        char[] chars = str.toCharArray();
        backtrace(result, stringBuilder, chars, used);
        return result;
    }

    private void backtrace(List<String> result, StringBuilder stringBuilder, char[] chars, boolean[] used) {
        if (stringBuilder.length() == chars.length) {
            result.add(stringBuilder.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            stringBuilder.append(chars[i]);
            backtrace(result, stringBuilder, chars, used);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation p = new Permutation();
        List<String> abc = p.permute("abc");
        String string = Arrays.toString(abc.toArray());
        System.out.println("string = " + string);
    }
}
