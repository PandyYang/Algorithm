package com.pandy.base.array;

import java.util.LinkedHashMap;

/**
 * @author: Pandy
 * @create: 2022/6/6
 * <p>
 * 第一个只出现一次的字符
 **/
public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> data = new LinkedHashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            Integer count = data.getOrDefault(c, 0);
            data.put(c, count + 1);
        }

        Character res = null;
        for (Character c : data.keySet()) {
            if (data.get(c) == 1) {
                res = c;
                break;
            }
        }

        if (res == null) {
            return -1;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == res) {
                return i;
            }
        }

        return -1;
    }

}
