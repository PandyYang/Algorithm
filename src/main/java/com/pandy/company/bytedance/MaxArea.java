package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/3
 * <p>
 * 盛水最多的容器
 **/
public class MaxArea {

    public int maxArea(int[] arr) {
        int left = 0, right = arr.length - 1;
        int cap = 0;
        while (left < right) {
            cap = Math.max(Math.min(arr[left], arr[right]) * (right - left), cap);
            if (arr[left] < arr[right]) left++;
            else right--;
        }
        return cap;
    }
}
