package com.pandy.base.math;

public class CountBits {

    // 对于任意整数x，令x=x&(x-1),该运算会将x的二进制的表示的最后一个1变成0，
    // 对x重复该操作，直到x变为0，操作次数即为x中的1比特数。
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
