package com.pandy.base.string;

import java.util.Objects;

/**
 * @author: Pandy
 * @create: 2022/1/15
 * <p>
 * 反转句子
 * <p>
 * 给你一个字符串 s ，颠倒字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，
 * 单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 **/
public class ReverseSentence {

    public static String reverseSentence(String str) {
        str = str.trim();
        if (str == null || str.trim().equals("")) return str;

        String[] split = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!Objects.equals(split[i], "")) {
                builder.append(split[i]);
                if (i != 0) builder.append(" ");
            }

        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = reverseSentence("student.  a am I ");
        System.out.println("s = " + s);
    }
}
