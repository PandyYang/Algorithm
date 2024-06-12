package com.pandy.huawei.shousi;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReplaceWords {

    public String replace2(String[] dictionary, String sentence) {
        String[] words = sentence.split(" ");
        Set<String> dicSet = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String substring = word.substring(0, j + 1);
                if (dicSet.contains(substring)) {
                    words[i] = substring;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public String replace(String[] dictionary, String sentence) {
        String[] sentSplitList = sentence.split(" ");

        StringBuffer stringBuffer = new StringBuffer();

        for (String s : sentSplitList) {

            String minPrefix = "";
            int minLenPrefix  = Integer.MAX_VALUE;
            for (String s1 : dictionary) {
                if (s.startsWith(s1)) {
                    if (s1.length() < minLenPrefix) {
                        minPrefix = s1;
                        minLenPrefix = s1.length();
                    }
                }
            }

            if (minLenPrefix != Integer.MAX_VALUE) {
                stringBuffer.append(minPrefix).append(" ");
            } else {
                stringBuffer.append(s).append(" ");
            }
        }
        return stringBuffer.toString().substring(0, stringBuffer.length() - 1);
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        String replace = replaceWords.replace(new String[]{"cat", "bat", "rat"}, "the cattle was rattled by the battery");
        System.out.println("replace = " + replace);
    }
}
