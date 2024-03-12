package com.pandy.base.array.package01;

/**
 * @author: Pandy
 * @create: 2022/6/6
 * <p>
 * 找出数组中重复的数字
 * 在一个长度n的数组里所有的数字都在0 ~ n - 1范围内。数组中某些数字是重复的，但是不知道有几个数字重复了，请找出数组中任意一个重复的数字。
 * 例如长度为7的数组{2，3，1，0，2，5，3}，那么对应输出为数字2或3。
 * <p>
 * 由于数组内数字在 0 ~ n-1 的范围内，可以将数组按 数字做下标 进行重排序
 * 将 n 放置到 num[n] 上，交换之前再判定在 num[n] 上是否为相同数字
 **/
public class Duplicate {

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || numbers.length == 0) return false;

        for (int i = 0; i < length; i++) {

            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    return true;
                }

                // 如果arr[i]的值与arr中下标为arr[i]的值不相等，则互换两个值
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }
}
