package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * <p>
 * 不适用加减乘除求两个整数的和
 * <p>
 * 位运算
 * 异或是一种不进位的加减法
 * 求与 之后 左移一位来可以表示进位
 * <p>
 * https://leetcode-solution-leetcode-pp.gitbook.io/leetcode-solution/easy/371.sum-of-two-integers
 **/
public class GetSum {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int carry = a & b;
            // 计算无进位的结果
            a = a ^ b;
            //将存在进位的位置置1
            b = carry << 1;
        }
        return a;
    }
}
