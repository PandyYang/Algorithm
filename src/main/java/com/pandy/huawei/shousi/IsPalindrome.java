package com.pandy.huawei.shousi;

import java.util.Deque;
import java.util.LinkedList;

public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        Deque<String> stringDeque1 = new LinkedList<>();
        Deque<String> stringDeque2 = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) {
                stringDeque1.addLast(String.valueOf(c).toLowerCase());
                stringDeque2.addFirst(String.valueOf(c).toLowerCase());
            }
        }
        return stringDeque1.equals(stringDeque2);
    }

    public static void main(String[] args) {
        boolean abcba = IsPalindrome.isPalindrome("abcba");
        System.out.println("abcba = " + abcba);
    }
}
