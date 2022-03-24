package com.pandy.base.array;

/**
 * @author Pandy
 * @date 24/3/2022
 *
 * 能盛水的最大容器
 */
public class MaxArea {

    public int maxArea(int[] arr) {
        int max = 0;
        for (int i = 0, j = arr.length - 1; i < j;) {
            int minLength = arr[i] < arr[j] ? arr[i++] : arr[j--];
            max = Math.max(max, (j-i+1) * minLength);
        }
        return max;
    }
}
