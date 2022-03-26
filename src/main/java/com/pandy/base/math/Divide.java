package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/26
 **/
public class Divide {
    public int divide(int dividend, int divisor) {

        // 溢出的情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 记录符号位
        int sign = -1;
        if ((dividend > 0 && divisor >0) || (dividend < 0 && divisor < 0)) {
            sign = 1;
        }

        // 全部转换成负数 防止溢出 因为负数比正数范围更大 -128 -  127
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        int ans = 0;

        // 都是负数的时候 比较正好相反
        while (dividend <= divisor) {

            // 每次递增的数
            int temp = divisor, count = 1;

            // 除完有余数 说明最少是2倍大小
            while (temp >= dividend - temp) {
                temp += temp; // 每次需要多减去一个除数
                count += count; // 商累加
            }
            dividend -= temp; // 每次需要多减去一个除数
            ans += count; // 计算商
        }

        return sign < 0 ? -ans : ans;

    }
}
