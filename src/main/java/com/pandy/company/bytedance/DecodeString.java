package com.pandy.company.bytedance;

import java.util.Stack;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 字符串解码
 * <p>
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的输入。
 **/
public class DecodeString {
    public String decodeString(String s) {
        StringBuffer ans = new StringBuffer();

        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();

        int multi = 0;
        for (char c : s.toCharArray()) {
            // 数字
            if (Character.isDigit(c)) {
                multi = multi * 10 + c - '0';
            // 左括号
            } else if (c == '[') {
                ansStack.add(ans);
                multiStack.add(multi);
                ans = new StringBuffer();
                multi = 0;
            // 字母
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            // 右括号
            } else {
                StringBuffer ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) {
                    ansTmp.append(ans);
                }
                ans = ansTmp;
            }
        }
        return ans.toString();
    }
}
