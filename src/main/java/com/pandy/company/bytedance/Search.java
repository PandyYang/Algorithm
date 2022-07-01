package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/1
 *
 *  搜索旋转排序数组
 *
 * */
public class Search {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            // 7
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
                // 中间的值小于最右边的值
            } else if (nums[mid] < nums[right]) {
                // 右边是有序的 判断target在不在右边 如果在则逐步缩小
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 中间的值大于最右边的值 那么左边是有序的 同样缩小搜索范围
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
