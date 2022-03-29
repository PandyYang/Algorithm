package com.pandy.base.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Pandy
 * @date 29/3/2022
 */
public class FirstUniqueChar {

    public static char firstUniqueChar(String s) {

        if (s.equals("")) return ' ';

        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            if (characterIntegerEntry.getValue() == 1) {
                return characterIntegerEntry.getKey();
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        char z = firstUniqueChar("Z");
        System.out.println("z = " + z);
    }
}
