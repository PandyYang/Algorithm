package com.pandy.huawei.three;

public class A75_SortColor {
    public void sortColors(int[] nums) {
        int red =0, white = 0, blue = 0;
        for (int num : nums) {
            if (num == 0) red++;
            if (num == 1) white++;
            if (num == 2) blue++;
        }

//        nums = new int[nums.length];
        int index = 0;
        while (red > 0) {
            nums[index++] = 0;
            red--;
        }

        while (white > 0) {
            nums[index++] = 1;
            white--;
        }

        while (blue > 0) {
            nums[index++] = 2;
            blue--;
        }
    }

    public void sortColors2(int[] nums) {
        int n = nums.length;
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
    }
}
