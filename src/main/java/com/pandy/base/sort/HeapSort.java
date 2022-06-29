package com.pandy.base.sort;

/**
 * @author Pandy
 * @date 21/4/2022
 */
public class HeapSort {

    void heapSort(int[] nums) {
        int size = nums.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            adjust(nums, size, i);
        }

        for (int i = size - 1; i >= 1; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            adjust(nums, i, 0);
        }
    }

    void adjust(int[] nums, int len, int index) {
        int l = 2 * index + 1;
        int r = 2 * index + 2;

        int maxIndex = index;
        if (l < len && nums[l] > nums[maxIndex]) maxIndex = l;
        if (r < len && nums[r] > nums[maxIndex]) maxIndex = r;
        if (maxIndex != index) {
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[index];
            nums[index] = temp;
            adjust(nums, len, maxIndex);
        }
    }
}
