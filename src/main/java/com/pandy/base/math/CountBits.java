package com.pandy.base.math;

public class CountBits {

    // ������������x����x=x&(x-1),������Ὣx�Ķ����Ƶı�ʾ�����һ��1���0��
    // ��x�ظ��ò�����ֱ��x��Ϊ0������������Ϊx�е�1��������
    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <=n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x = x & (x-1);
            ones ++;
        }
        return ones;
    }
}
