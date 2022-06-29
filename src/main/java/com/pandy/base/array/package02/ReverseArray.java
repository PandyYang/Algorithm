package com.pandy.base.array.package02;

/**
 * @author Pandy
 * @date 23/3/2022
 * <p>
 * 数组的反转
 */
public class ReverseArray {

    public static int[] reverseArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        int[] ints = reverseArr(arr);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
