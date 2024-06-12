package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class A49_groupArgument {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String key = new String(strChar);
            if (map.containsKey(key)) {
                List<String> strings = map.get(key);
                strings.add(str);
                map.put(key, strings);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }

        for (String chars : map.keySet()) {
            res.add(map.get(chars));
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new A49_groupArgument().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        String string = Arrays.toString(lists.toArray());
        System.out.println("string = " + string);
    }
}
