package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/3/27
 **/
public class Fib {

    private final int mod = 1000000007;

    public int fib(int n) {
        int f0 = 0, f1 = 1;
        if (n < 2) return n;
        int res = 1;
        for (int i = 1; i < n; i++) {
            res = (f0 + f1) % mod;
            f0 = f1 % mod;
            f1 = res % mod;
        }
        return res;
    }
}
