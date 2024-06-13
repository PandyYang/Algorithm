package com.pandy.huawei.three;

import java.util.Arrays;

public class A581_FindUnsortedSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] newnums = nums.clone();
        Arrays.sort(newnums);

        int i=0,j= n-1;

        while(i < n && nums[i] == newnums[i]) ++i;
        while(j > i && nums[j] == newnums[j]) --j;

        return j-i+1;
    }
}
