package com.pandy.base.array;

/**
 * 删除有序数组的重复项
 */

class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i = removeDuplicates.removeDuplicates(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4});
        System.out.println(i);
    }
}
