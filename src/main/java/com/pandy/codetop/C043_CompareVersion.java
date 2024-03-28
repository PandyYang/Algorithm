package com.pandy.codetop;

public class C043_CompareVersion {
    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int length = Math.max(nums1.length, nums2.length);
        for (int i = 0; i < length; i++) {
            // 如果某个版本号的修订号用尽，则默认其值为0。
            int num1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int num2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (num1 > num2) return 1;
            if (num1 < num2) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int i = compareVersion("1.01.2", "1.01.3");
        System.out.println("i = " + i);
    }
}
