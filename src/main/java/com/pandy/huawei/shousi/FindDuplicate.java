package com.pandy.huawei.shousi;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i +1;
            while (j > 0) {
                if((nums[i] ^ nums[j]) == 0) {
                    return nums[i];
                }
                j--;
            }
        }
        return -1;
    }
}
