package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/8
 * 输⼊⼀个整数数组，实现⼀个函数来调整该数组中数字的顺序，使得所有
 * 奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *
 * 解法：
 * 双指针遍历，从前遍历寻找偶数，从前遍历寻找奇数
 * 找到之后 交换
 **/
public class EvenAndOdd {
    public static void reOrder(int[] datas) {

        if (datas == null || datas.length <= 0) {
            return;
        }

        int begin = 0;
        int end = datas.length - 1;
        int temp = -1;

        while (begin < end) {
            // 从前移动begin，直到它指向偶数
            while (begin < end && datas[begin] % 2 != 0)
            {
                begin++;
            }
            // 从后移动pEnd，直到它指向奇数
            while (begin < end && datas[end] % 2 == 0)
            {
                end--;
            }

            if (begin < end)
            {
                // 交换偶数和奇数
                temp = datas[begin];
                datas[begin] = datas[end];
                datas[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,6,4,7,8,2};
        reOrder(arr);
        for (int i : arr) {
            System.out.println("i = " + i);
        }
    }
}
