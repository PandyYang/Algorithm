package com.pandy.base.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (nums.length >= 3) {
            Arrays.sort(nums);

            int i = 0;
            while (i < nums.length - 2) {
                twoSum(nums, i, result);
                int temp = nums[i];

                // ���˵�����ظ���[1,1,1,2,3,-2,-3]
                while (i < nums.length && nums[i] == temp) {
                    ++i;
                }
            }
        }
        return result;
    }

    private void twoSum(int[] nums, int i, List<List<Integer>> result) {
        int j = i + 1; // �����
        int k = nums.length - 1; // ���ұ�
        while (j < k) {
            if (nums[i] + nums[j] + nums[k] == 0) {
                result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                int temp = nums[j];
                // ���˵��ظ���
                while (nums[j] == temp && j < k) {
                    ++j;
                }
            } else if (nums[i] + nums[j] + nums[k] < 0) {
                ++j;
            } else {
                --k;
            }
        }
    }
}
