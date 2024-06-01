package com.pandy.hot100;

import java.util.*;

/***
 * 字母异位词分组
 */
public class L49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            Arrays.sort(str.toCharArray());
            String s = new String(str);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
