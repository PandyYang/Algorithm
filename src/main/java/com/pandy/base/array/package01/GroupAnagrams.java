package com.pandy.base.array.package01;

import java.util.*;

/**
 * @author: Pandy
 * @create: 2022/3/27
 * <p>
 * 数组的相同元素分组
 **/
public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(arr);
        System.out.println(lists);
    }
}
