package com.pandy.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class L15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums.length - 1;
            int j = i+1;
            while (j < n) {
                if (nums[i] + nums[n] + nums[j] == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[n]));
                    j++;
                    n--;
                } else if (nums[i] + nums[n] + nums[j] > 0) {
                    n--;
                } else {
                    j++;
                }
            }
        }
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        L15 l15 = new L15();
//        List<List<Integer>> lists = l15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        List<List<Integer>> lists = l15.threeSum(new int[]{0,0,0});
        List<List<Integer>> collect = lists.stream().distinct().collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));
    }
}
