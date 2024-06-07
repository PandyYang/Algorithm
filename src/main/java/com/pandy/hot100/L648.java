package com.pandy.hot100;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class L648 {
    public static String words(String[] dictionary, String sentence) {
        String[] ss = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            int min = Integer.MAX_VALUE;
            String minStr = "";
            for (String string : dictionary) {
                if (s.startsWith(string)) {
                    if (string.length() <= min) {
                        minStr = string;
                    }
                    min = string.length();
                }
            }

            if (min == Integer.MAX_VALUE) {
                sb.append(s).append(" ");
            }

            if (!minStr.equals("")) {
                sb.append(minStr).append(" ");
            }

        }
        return sb.substring(0, sb.length() - 1);
    }

    public static String words2(String[] dictionary, String sentence) {
        return Arrays
                .stream(sentence.split(" "))
                .map(word -> Arrays.stream(dictionary)
                        .filter(word::startsWith)
                        .min(Comparator.comparing(String::length))
                        .orElse(word))
                .reduce((s1, s2) -> s1 + " " + s2)
                .get()
                .trim();
    }

    public static void main(String[] args) {
        String words = L648.words2(new String[]{"cat", "bat", "rat"}, "the cattle was rattled by the battery");
        System.out.println("words = " + words);
        String words2 = L648.words2(new String[]{"a", "b", "c"}, "aadsfasf absbs bbab cadsfafs");
        System.out.println("words2 = " + words2);
        String words3 = L648.words2(new String[]{"a", "aa", "aaa", "aaaa"}, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa");
        System.out.println("words3 = " + words3);
    }
}
