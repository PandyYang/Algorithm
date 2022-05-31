package com.pandy.base.array;

/**
 * @author Pandy
 * @date 27/12/2021
 * 每次只和前面一个数交换位置，或者利用辅助数组。
 */
public class ReOrderArray {
    public static void reOrderArray(int[] array) {
        if (array == null) return;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            // 奇数
            if (array[i] % 2 != 0) {
                // 遍历所有i之前的元素
                // 确保都是奇数
                while (j >= 0) {
                    if (array[j] % 2 != 0) {
                        break;
                    }
                    // 偶数 和前面的奇数调换顺序
                    if (array[j] % 2 == 0) {
                        int t = array[j + 1];
                        array[j + 1] = array[j];
                        array[j] = t;
                        j--;
                    }
                }
            }
            array[j + 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 6, 8, 4, 5};
        reOrderArray(arr);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
}
