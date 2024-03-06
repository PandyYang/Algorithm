package com.pandy.classic_150;

public class A012_ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        // -------------------------- Ԫ����ߵ�ֵ -------------------------
        int[] leftProducts = new int[n];
        // ��Ϊ����ߵĵ�һ������ û�и�������� ֻ����1
        leftProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            // ע��
            leftProducts[i] = leftProducts[i-1] * nums[i-1];
        }

        // --------------------------- Ԫ���ұߵ�ֵ -------------------------
        int[] rightProducts = new int[n];
        rightProducts[n-1] = 1;
        for (int i = n-2; i >= 0; i--) {
            rightProducts[i] = rightProducts[i+1] * nums[i+1];
        }

        // ---------------------------���ҵ�Ԫ�����-------------------------
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = leftProducts[i] * rightProducts[i];
        }
        return answer;
    }
}
