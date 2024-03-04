package com.pandy.base.array;

import java.util.Arrays;

/**
 * 给定⼀个⻓度为 N 的整形数组 arr，其中有 N 个互不相等的⾃然数
 * 1-N，请实现 arr 的排序，但是不要把下标 0∼N−1 位置上的数通过直接赋
 * 值的⽅式替换成 1∼N
 */
public class SortWithoutModifying {

    public static int[] sortWithoutModifying(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            // 判断当前位置的元素是不是正确
            while (arr[i] != i+1) {
                // 不正确将其交换到正确位置
                temp = arr[arr[i] - 1];
                // 假设当前遍历到的元素索引为 i，那么 arr[i] 表示的是当前元素应该在的位置上的值，
                // 而 arr[i] - 1 表示的是当前元素正确位置上的索引。
                // 因此，arr[arr[i] - 1] 表示的就是数组中正确位置上的元素的值。
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] ints = sortWithoutModifying(new int[]{3, 2, 1});
        System.out.println("Arrays.toString(ints) = " + Arrays.toString(ints));
    }
}
