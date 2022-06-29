package com.pandy.base.math;

/**
 * @author Pandy
 * @date 23/3/2022
 * <p>
 * 反转二进制的位
 */
public class ReverseBits {

    public int reverseBits(int n) {
        int ret = 0;
        int count = 32;
        while (count-- > 0) {
            int lastBit = n & 1; //获取 n 最后一位
            ret = ret << 1 | lastBit; //将结果左移一位后再添加 n 的最后一位
            n = n >> 1; // n 右移来减少一位
        }
        return ret;
    }
}
