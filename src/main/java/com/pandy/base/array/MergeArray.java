package com.pandy.base.array;

/**
 * @Author Pandy
 * @Date 2021/7/31 15:17
 * <p>
 * 合并两个数组 假设A数组的长度大于m+n-1
 * 从后往前对比 然后存入A即可，长度为m+n-1
 */
public class MergeArray {
    public static void merge(int[] A, int m, int[] B, int n) {

        // 各自长度 以及总长度
        int i = m - 1, j = n - 1, index = m + n - 1;

        // 从后往前 填充从大到小的数字
        while (i >= 0 && j >= 0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    public static void main(String[] args) {
        int[] arrA = new int[]{1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
        int[] arrB = new int[]{2, 4, 6, 8, 10};
        merge(arrA, 5, arrB, 5);
        for (int i : arrA) {
            System.out.println("i = " + i);
        }
    }
}
