package com.pandy.classic_150;

import java.util.HashMap;
import java.util.Map;

public class A015_RomanToInt {
    public static int romanToInt(String s) {
        // 定义罗马字符与整数的对应关系
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevValue = 0;
        // 遍历字符串，对每个字符进行处理
        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = romanMap.get(s.charAt(i));
            // 如果当前字符代表的整数比其后面的字符代表的整数小，则减去当前值
            if (curValue < prevValue) {
                result -= curValue;
            } else {
                // 否则，加上当前值
                result += curValue;
            }
            prevValue = curValue;
        }

        return result;
    }

    public static void main(String[] args) {
        int i = romanToInt("IV");
        System.out.println("i = " + i);
    }
}
