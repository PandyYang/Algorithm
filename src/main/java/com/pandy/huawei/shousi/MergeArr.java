package com.pandy.huawei.shousi;

public class MergeArr {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m - 1;
        int b = n - 1;
        int p = m + n - 1;
        while (a >= 0 && b >= 0) {
            nums1[p--] =  nums1[a] > nums2[b] ? nums1[a--] : nums2[b--];
        }

        while (b >= 0) {
            nums1[p--] = nums2[b--];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0};
        int[] arr2 = new int[]{1};
        MergeArr.merge(arr, 0, arr2, 1);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
}
