package com.pandy.od;

import java.util.*;

public class Main16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flaw = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        // 元音字母集合
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        // 记录元音字母下标
        ArrayList<Integer> vowelIdxs = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelIdxs.add(i);
            }
        }

        // 初始化双指针
        int left = 0, right = 0;
        // 满足条件的子串
        ArrayList<Object> length = new ArrayList<>();

        while (right < vowelIdxs.size()) {
            int lengthDiff = vowelIdxs.get(right) - vowelIdxs.get(left) - (right - left);
            // 瑕疵大 则收缩左边
            if (lengthDiff > flaw) {
                left ++;
            } else {
                if (lengthDiff == flaw) {
                    // 收集
                    length.add(vowelIdxs.get(right) - vowelIdxs.get(left) + 1);
                }
                right++;
            }
        }
        if (length.isEmpty()) {
            System.out.println(0);
            return;
        }

        Collections.sort(length, Collections.reverseOrder());
        System.out.println(length.get(0));
    }
}
