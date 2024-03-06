package com.pandy.classic_150;

public class A016_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;
        int len = 0;
        while (s.charAt(index) == ' ') {
            index--;
        }

        while ((index >= 0) && s.charAt(index) != ' ') {
            len++;
            index--;
        }
        return len;
    }
}
