package com.pandy.od;

import java.util.*;

public class Main23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(findKthSubstringLength(s, k));
    }

    public static int findKthSubstringLength(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        char[] chars = s.toCharArray();

        int maxCount = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            while (i + 1 < chars.length && chars[i] == chars[i + 1]) {  // 计算连续出现的字符数量
                count++;
                i++;
            }
            maxCount = Math.max(maxCount, count);
            countMap.put(chars[i], count); // 此处更新同一个值的count 相同字母取最长的子串
        }

        List<Integer> counts = new ArrayList<>(countMap.values());
        Collections.sort(counts, Collections.reverseOrder());

        if (k > counts.size()) {
            return -1;
        } else {
            return counts.get(k - 1);
        }
    }
}

