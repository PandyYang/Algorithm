package com.pandy.base.string;

/**
 * @author: Pandy
 * @create: 2022/1/15
 *
 * 反转句子
 **/
public class ReverseSentence {

    public static String reverseSentence(String str) {
        if (str == null || str.trim().equals("")) return str;

        String[] split = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1;  i >= 0 ; i--) {
            builder.append(split[i]);

            if (i != 0) builder.append(" ");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = reverseSentence("student. a am I");
        System.out.println("s = " + s);
    }
}
