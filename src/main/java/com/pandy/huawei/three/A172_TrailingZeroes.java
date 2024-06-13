package com.pandy.huawei.three;

public class A172_TrailingZeroes {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n; // 有多少个数可以贡献5
        }
        return count;
    }
}
