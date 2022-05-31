package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * 
 * 
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数
 **/
public class HammingWeight {


    /**
     * 具体代码中，当检查第 ii 位时，我们可以让 nn 与 2^i2
     * i进行与运算，当且仅当 nn 的第 ii 位为 11 时，运算结果不为 00。
     *
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            // 2得i次方
            if ((n & (1 << i)) != 0) {
                ret++;
            }
        }
        return ret;
    }


    public int hammingWeight2(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }
}
