package com.pandy.offer;

/**
 * 题目：输入字符串s1和s2，如何判断字符串s2中是否包含字符串s1的某个变位词？如果字符串s2中包含字符串s1的某个变位词，
 * 则字符串s1至少有一个变位词是字符串s2的子字符串。假设两个字符串中只包含英文小写字母。例如，字符串s1为"ac"，字符串s2为"dgcaf"，
 * 由于字符串s2中包含字符串s1的变位词"ca"，因此输出为true。如果字符串s1为"ab"，字符串s2为"dgcaf"，则输出为false。
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        int[] count = new int[26];

        for (int i = 0; i < s1.length(); ++i) {
            // 这句记录s1在count中
            count[s1.charAt(i) - 'a']++;
//            // 判断在已不在此处的s1的区间内
//            count[s2.charAt(i) - 'a']--;
        }

//        if(areAllZero(count)) return true;

        // 注意一定要限制滑动窗口的长度是s1的长度
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i) - 'a'] --;
            if (i >= s1.length()) {
                count[s2.charAt(i-s1.length()) - 'a'] ++;
            }
        if (areAllZero(count)) return true;
        }

        return false;
    }

    private boolean areAllZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        boolean b = checkInclusion.checkInclusion("eac", "abdcaef");
        System.out.println("b = " + b);
    }
}
