package com.pandy.base.array;

/**
 * 删除有序数组的重复项
 * 要求原地删除
 */

class RemoveDuplicates {

    public int remove(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i]  = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int i2 = removeDuplicates.remove(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4});
        System.out.println(i2);
    }
}
