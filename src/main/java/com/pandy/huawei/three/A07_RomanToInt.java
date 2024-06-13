package com.pandy.huawei.three;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class A07_RomanToInt {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int preValue = 0;
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Integer curValue = map.get(s.charAt(i));
            if (curValue < preValue) {
                res -= curValue;
            } else {
                res += curValue;
            }
            preValue = curValue;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = new A07_RomanToInt().romanToInt("IV");
        System.out.println("i = " + i);
    }
}
