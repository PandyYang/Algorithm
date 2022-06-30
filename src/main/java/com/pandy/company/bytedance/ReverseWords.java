package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/1
 **/
public class ReverseWords {

    public String reverseWords(String str) {
        String[] s = str.split(" ");
        StringBuffer stringBuffer = new StringBuffer();

        for (int i = s.length - 1; i >= 0 ; i--) {
            if (!s[i].isBlank()) {
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder reverse = stringBuilder.append(s[i]).append(" ");
                stringBuffer.append(reverse);
            }
        }
        return stringBuffer.toString().strip();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        String s = reverseWords.reverseWords("a good   example");
        System.out.println("s = " + s);
    }
}
