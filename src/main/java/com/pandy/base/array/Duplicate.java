package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/6/6
 *
 * 数组中的重复的数字
 *
 * 由于数组内数字在 0 ~ n-1 的范围内，可以将数组按 数字做下标 进行重排序
 * 将 n 放置到 num[n] 上，交换之前再判定在 num[n] 上是否为相同数字
 **/
public class Duplicate {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;

        for (int i = 0; i < numbers.length; i++) {
            while (numbers[i] != i) {
                int number = numbers[i];
                int wrongNum = numbers[number];
                if (number == wrongNum) {
                    duplication[0] = number;
                    return true;
                }
                swap(numbers, i, number);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = nums[i];
    }
}
