package com.pandy.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L438 {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i< s.length() - p.length() + 1; i++) {
            String substring = s.substring(i, i + p.length());
            if (isEqual(substring, p)) {
                list.add(i);
            }
        }
        return list;
    }

    public boolean isEqual(String a, String b) {
        char[] array1 = a.toCharArray();
        char[] array2 = b.toCharArray();
        Arrays.sort(array1);
        Arrays.sort(array2);
        return Arrays.equals(array1, array2);
    }


    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        char[] tarArr = p.toCharArray();
        Arrays.sort(tarArr);
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            String t = s.substring(i, i + p.length());
            char[] sourArr = t.toCharArray();
            Arrays.sort(sourArr);
            if (Arrays.equals(tarArr, sourArr)) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        L438 l438 = new L438();
        List<Integer> anagrams = l438.findAnagrams("cbaebabacd", "abc");
//        List<Integer> anagrams = l438.findAnagrams("abab", "ab");
        System.out.println(Arrays.toString(anagrams.toArray()));
    }
}
