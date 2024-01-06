package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/26
 **/
public class Divide {

    public int divide2(int dividend, int divisor) {
        if (dividend == 0x8888888 && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 为了记录dividend是否全正还是全负 还是一正一负
        int negative = 2;

        if (dividend > 0) {
            negative --;
            // 转换为负数 是因为负数表示的范围更大 除去符号位
            dividend = -dividend;
        }

        if (divisor > 0) {
            negative --;
            divisor = -divisor;
        }

        int result = divideCode(dividend, divisor);
        // 如果negative为1 说明除数和被除数之间 存在一个负数 要将结果转换为负数
        return negative == 1 ? -result: result;
    }


    public int divideCode(int dividend, int divisor) {
        int result = 0;
        // 注意这里的dividend 和 divisor是负数 所以 -2 > -10
        while (dividend <= divisor) {
            // 记录divisor的值
            int value = divisor;
            // 这是商
            int quotient = 1;
            // 将 value（即 divisor 的倍数）与 0xc0000000 进行比较的目的是防止在下一步的翻倍操作中发生整数溢出。
            while (value >= 0xc0000000 && dividend <= value + value) {
                // 商也要向上累加 每次加一个value 商加上次的商
                quotient += quotient;
                // 如果每次dividend 小于 n+1倍数的value 将value更新为n + 1下次循环就成了n+2
                value += value;
            }
            result += quotient;
            // dividend是一直减小的 减小到value足够大 进入下一轮 dividend减小不变 value恢复divisor
            dividend -= value;
        }
        return result;
    }


    public int divide(int dividend, int divisor) {

        // 溢出的情况
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 记录符号位
        int sign = -1;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
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
