package com.pandy.base.array;

import java.util.Arrays;
import java.util.List;

/**
 * @author Pandy
 * @date 5/1/2022
 * 求下一个排列
 */
public class NextPermutation {
    //
    public void next(int[] arr) {

        int k = arr.length - 2;
        while (k >= 0 && arr[k] > arr[k+1])
            k--;
        if (k < 0) {
            Arrays.sort(arr);
            return;
        }
        int i = k+2;
        while (i < arr.length && arr[i] > arr[k])
            i++;
        // 找到降序的一个序列值
        int temp = arr[k];
        arr[k] = arr[k-1];
        arr[k-1] = temp;

        int start = k+1, end = arr.length - 1;
        while (start < end) {
            int reTemp = arr[start];
            arr[start] = arr[end];
            arr[end] = reTemp;
            start ++;
            end --;
        }
    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for (int i = len - 1; i > 0 ; i--) {
            if (nums[i] > nums[i-1]) {
                Arrays.sort(nums, i, len);
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i-1]) {
                        int temp = nums[i];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
