package com.pandy.base.traceback;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/3/28
 **/
public class Permutation {

    public String[] permutation(String s) {
        char[] chars = new char[s.length()];
        Set<String> set = new HashSet<>();

        boolean[] isViewed = new boolean[s.length()];
        dfs(s, 0, chars, isViewed, set);
        return set.toArray(new String[0]);
    }

    private void dfs(String s, int index, char[] chars, boolean[] isViewed, Set<String> set) {
        if (index == s.length()){
            set.add(new String(chars));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isViewed[i]) continue;
            isViewed[i] = true;
            chars[index] = s.charAt(i);
            dfs(s, index + 1, chars, isViewed, set);
            isViewed[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] abcs = permutation.permutation("abc");
        for (String abc : abcs) {
            System.out.println("abc = " + abc);
        }
    }
}
