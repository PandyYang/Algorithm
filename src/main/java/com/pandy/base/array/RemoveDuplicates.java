package com.pandy.base.array;

/**
 * @author Pandy
 * @date 23/3/2022
 *
 * 删除数组中重复出现的元素，原地删除，O(1)空间
 * 使用双指针，读写指针进行解决
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int i = 0, j = 1;
        while (j < nums.length) {
            //
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static int remove2(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 5, 5, 6};
        int i = removeDuplicates(arr);
        System.out.println(i);
    }
}
