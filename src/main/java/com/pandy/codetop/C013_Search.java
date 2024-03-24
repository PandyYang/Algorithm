package com.pandy.codetop;

/**
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
 * 此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 *
 * 4 5 6 7 0 1 2          2
 */
public class C013_Search {
    public static int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            // 7
            int mid = (left + right) /2;

            if (nums[mid] == target) {
                return mid;
            }
            // 右边有序
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                // 左边有序
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int search = C013_Search.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2);
        System.out.println("search = " + search);
    }
}
