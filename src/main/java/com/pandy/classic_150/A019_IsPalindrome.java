package com.pandy.classic_150;

public class A019_IsPalindrome {
    public boolean isPalindrome(String s) {
        // 预处理：将所有字符转换为小写，移除非字母数字字符
        StringBuilder sb = new StringBuilder();
        for (char c : s.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        // 正着读和反着读比较
        String processedStr = sb.toString();
        int left = 0, right = processedStr.length() - 1;
        while (left < right) {
            if (processedStr.charAt(left) != processedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
