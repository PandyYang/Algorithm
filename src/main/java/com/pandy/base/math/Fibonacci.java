package com.pandy.base.math;

/**
 * @author Pandy
 * @date 27/12/2021
 * 输入一个整数n，输出斐波那契数列的第n项
 */
public class Fibonacci {
    public long fibonacci(int n) {
        long result = 0;
        long preOne = 1;
        long preTwo = 0;
        if (n == 0) {
            return preTwo;
        }

        if (n == 1)
            return preOne;

        for (int i = 2; i <= n; i++) {
            result = preOne + preTwo;
            preTwo = preOne;
            preOne = result;
        }
        return result;
    }
}
