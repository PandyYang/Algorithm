package com.pandy.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int j = i + 1;
            for (int k = nums.length - 1; k > 0; k--) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;

                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        String string = Arrays.toString(lists.toArray());
        System.out.println("string = " + string);
    }
}
