package com.pandy.huawei.simulation._04;

import java.util.Arrays;
import java.util.Scanner;

public class HJ34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 将字符串转换为字符数组
        char[] chars = input.toCharArray();

        // 对字符数组进行冒泡排序
        bubbleSort(chars);

        // 将排序后的字符数组转换回字符串
        String sortedString = new String(chars);

        // 输出排序后的字符串
        System.out.println(sortedString);

        scanner.close();
    }

    // 冒泡排序算法
    private static void bubbleSort(char[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    // 交换相邻的元素
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
