package com.pandy.huawei;

public class MergeOrderArr {

    public static void merge(int[] A, int m, int[] B, int n) {

        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;

        while (i >=0 && j >=0) {
            A[index --] = A[i] < B[j] ? B[j--] : A[i--];
        }

        while (j >= 0) {
            A[index--] = B[j--];
        }
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0}, 3, new int[]{2,5,6}, 3);

    }
}
