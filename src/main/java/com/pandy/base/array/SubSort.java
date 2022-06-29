package com.pandy.base.array;

/**
 * @author Pandy
 * @date 24/3/2022
 * <p>
 * 排序子数组
 * <p>
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。函数返回值为[m,n]，
 * `若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 */
public class SubSort {

    public int[] subSort(int[] array) {
        int N = array.length, start = -1, end = -1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        // 从前往后找目标末位 使得从该位到最后 数组保持递增
        for (int i = 0; i < N; i++) {
            if (array[i] > max) {
                max = array[i];
            } else {
                end = i;
            }
        }

        // 数据恒递增 说明数组是有序的
        if (end == -1) return new int[]{-1, -1};


        for (int i = end; i >= 0; i--) {
            if (array[i] <= min) {
                min = array[i];
            } else {
                start = i;
            }
        }

        return new int[]{start, end};

    }
}
