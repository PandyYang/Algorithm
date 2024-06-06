package com.pandy.huawei;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        int maxLen = 0;
        String res = "";

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j + i <= s.length(); j++) {
                String a = s.substring(j, i+j);
                if (isPalindrome(a) && a.length() > maxLen) {
                    res = a;
                    maxLen = a.length();
                }
            }
        }
        return res;
    }

    public static  boolean isPalindrome(String a){
        int left = 0;
        int right = a.length() - 1;
        while (left <= right) {
            if (a.charAt(left) == a.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("cddb");
        System.out.println("s = " + s);
    }
}
