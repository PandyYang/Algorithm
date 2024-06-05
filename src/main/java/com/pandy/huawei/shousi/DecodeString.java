package com.pandy.huawei.shousi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DecodeString {
    public String decodeString(String s) {
        Pattern pattern = Pattern.compile("\\[(\\d+)\\]");
        Matcher matcher = pattern.matcher(s);

        String[] split = s.split("\\[\\]");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < matcher.groupCount(); i++) {
            for (int j = 0; j < Integer.parseInt(matcher.group(i)); j++) {
                stringBuilder.append(split[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        String s = decodeString.decodeString("3[a]2[bc]");
        System.out.println("s = " + s);
    }
}
