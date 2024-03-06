package com.pandy.classic_150;

public class A003_RemoveDuplicates {
    int i = 0;
    public int removeDuplicates(int[] nums) {
        for (int j = 1; j < nums.length; j++) {
            //
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
}
