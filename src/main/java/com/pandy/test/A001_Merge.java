package com.pandy.test;

import java.util.Arrays;

public class A001_Merge {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1;
        int j = n -1;
        int p = m + n -1;
        while (i >= 0 && j >= 0) {
            // 题目要求从小到大，此时完全反向思维
            nums1[p--]= nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        while (j >= 0) {
            nums1[p--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3,0,0,0};
        int[] arr2 = new int[]{2,5,6};
        merge(arr1, 3, arr2, 3);
        System.out.println("Arrays.toString(arr1) = " + Arrays.toString(arr1));
    }
}
