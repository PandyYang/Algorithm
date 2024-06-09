package com.pandy.hot100;

import java.util.Arrays;

public class L16_ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {

        int closeNum = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int l = nums.length - 1;
            while (j < l) {
                int sum = nums[i] + nums[j] + nums[l];

                if (sum == target) {
                    return sum;
                } else {
                    if (Math.abs(sum - target) < Math.abs(target - closeNum)) {
                        closeNum = sum;
                    }

                    if (sum > target) {
                        l--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return closeNum;
    }
}
