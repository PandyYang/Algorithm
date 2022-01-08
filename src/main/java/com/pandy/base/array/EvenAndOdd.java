package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/8
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
