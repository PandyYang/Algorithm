package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/8
 * 输⼊⼀个整数数组，实现⼀个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 **/
public class EvenAndOdd {

    public static void mysort(int[] arr) {
        if (arr == null) return;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            while (left < right && isEven(arr[left])) {
                left ++ ;
            }

            while (left < right && isEven(arr[right])) {
                right --;
            }

            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
            if (left >= right) break;
        }
    }

    private static boolean isEven(int i) {
        return (i & 0x1) == 0;
    }
}
