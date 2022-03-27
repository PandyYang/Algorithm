package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/27
 **/
public class PrintNumbers {
    public int[] print(int n) {
        int m = (int) Math.pow(10, n);
        int[] a = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            a[i] = i + 1;
        }
        return a;
    }
}
