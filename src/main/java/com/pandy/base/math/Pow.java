package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/27
 **/
public class Pow {

    /**
     * 假如n=10，二进制为1010，从左至右分别对应x^8,x^4,x^2,x^1。
     * 也就是说当从右到左，迭代时，如果bit==1，那么执行res*=x，而且每迭代一次，x^n = x^2n。
     * 
     * 
     * 
     * 代码虽然牛批，但个人感觉描述不太清楚，for循环的次数即i作减半直到为1的次数，而x *= x;相当于对幂作加倍，
     * 加倍的次数正好等于减半的次数。但是由于i/2在i为奇数时会造成损失，损失量刚好是上一次的x值，
     * 需要把这个值乘到res里面做弥补，同时最后一次i/2必然为1即奇数，所以最终得到的x和损失量相乘得到最终结果
     *
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if ((i & 1) == 1) {
                res *= x;
            }

            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public static void main(String[] args) {
        double v = myPow2(2, 4);
        System.out.println("v = " + v);
    }

    public double myPow(double x, int n) {

        if (n == 0) return 1;

        if (x == 0) return 0;

        int flag = 1;
        double res = 1;

        if (x < 0) {
            flag = -1;
            x = -x;
        }

        while (n != 0) {
            res = res * x;
            n -= 1;
        }

        if (flag == -1) {
            res = 1 / res;
        }

        return res;
    }
}
