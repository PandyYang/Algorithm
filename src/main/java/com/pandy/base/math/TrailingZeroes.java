package com.pandy.base.math;

/**
 * @author Pandy
 * @date 23/3/2022
 * <p>
 * 给定一个整数n，返回n！，求结尾数中零的数量
 * <p>
 * <p>
 * 我们需要求解这 n 个数字相乘的结果末尾有多少个 0，由于题目要求 log 的复杂度，因此暴力求解是不行的。
 * 通过观察，我们发现如果想要结果末尾是 0，必须是分解质因数之后，2 和 5 相乘才行，
 * 同时因数分解之后发现 5 的个数远小于 2， 因此我们只需要求解这 n 数字分解质因数之后一共有多少个 5 即可.
 */
public class TrailingZeroes {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
