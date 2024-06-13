package com.pandy.huawei.three;

public class A169_MajorityElement {
    public int majorityElement(int[] nums) {
        int cd = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == cd) {
                count++;
            } else {
                count--;
            }

            if (count <= 0) {
                cd = nums[i];
                count = 1;
            }
        }
        return cd;
    }
}
