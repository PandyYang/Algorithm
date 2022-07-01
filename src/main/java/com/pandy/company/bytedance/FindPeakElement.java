package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 * 寻找峰值
 **/
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <r) {
            int mid = l + (r - l) / 2;
            // 下坡不一定遇到峰值
            if (nums[mid] > nums[mid+1]) {
                r = mid;
            } else {
                // 上坡一定能遇见峰值
                l = mid + 1;
            }
        }
        return l;
    }
}
