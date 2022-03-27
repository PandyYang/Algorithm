package com.pandy.base.recursion;

/**
 * @author: Pandy
 * @create: 2022/3/27
 *
 * 爬楼梯
 *
 * 动态规划
 **/
public class ClimbStairs {

    public static int climbStairs(int n) {

        if (n <= 2) return n;

        int i1 = 1;
        int i2 = 2;

        for (int i = 3; i <= n; i++) {
            int temp = i1 + i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }

    public static void main(String[] args) {
        int i = climbStairs(4);
        System.out.println("i = " + i);
    }
}
