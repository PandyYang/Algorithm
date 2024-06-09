package com.pandy.huawei;

import java.util.Arrays;

public class BubbleSort {

    public static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,5,6,7,9};
        int[] sort = sort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
