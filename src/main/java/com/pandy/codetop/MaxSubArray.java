package com.pandy.codetop;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            // ������ ����Լ�������Ԫ��
            if (sum > 0) {
                sum += nums[i];
            } else {
                // û������ ������Ϊ��ǰֵ
                sum = nums[i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }

}
