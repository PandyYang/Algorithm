package com.pandy.base.array;

/**
 * @author Pandy
 * @date 23/3/2022
 *
 * 由于题目没有对空间复杂度有求，用一个 hashmap 存储已经访问过的数字即可。
 * 假如题目空间复杂度有要求，由于数组是有序的，只需要双指针即可。一个 left 指针，一个 right 指针，
 * 如果 left + right 值 大于 target 则 right 左移动， 否则 left 右移
 *
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[]{left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right --;
            } else {
                left ++;
            }
        }
        return new int[]{-1, -1};
    }
}
