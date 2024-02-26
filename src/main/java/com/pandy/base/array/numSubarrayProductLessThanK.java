package com.pandy.base.array;

public class numSubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long product = 1;
        int left = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (left <= i && product >= k) {
                // ʹ��һ�� while ѭ������ product ���ڻ���� k ʱ���� product �г�ȥ��߽��Ԫ�� (nums[left]) ���ƶ���߽磨left++����
                product /= nums[left++];
            }
            // �������ڵĳ˻�С�� k ʱ���ӵ�ǰ��߽絽�ұ߽�����������鶼������������
            count += i >= left? i - left + 1 : 0;
        }
        return count;
    }
}
