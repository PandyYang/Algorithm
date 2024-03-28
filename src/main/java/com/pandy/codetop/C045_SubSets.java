package com.pandy.codetop;

import java.util.ArrayList;
import java.util.List;

public class C045_SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrace(0, nums, new ArrayList<Integer>(), output);
        return output;
    }

    private void backtrace(int start, int[] nums, List<Integer> current, List<List<Integer>> output) {
        output.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrace(i+1, nums, current, output);
            current.remove(current.size() - 1);
        }
    }
}
