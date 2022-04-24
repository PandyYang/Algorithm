package com.pandy.base.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Pandy
 * @create: 2022/3/27
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

    public static int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num : nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
//        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
//        List<List<String>> lists = groupAnagrams(arr);
//        System.out.println(lists.toString());

        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray(arr);
        System.out.println(i);
    }
}
