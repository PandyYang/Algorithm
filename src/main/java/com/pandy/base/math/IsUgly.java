package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/23
 *
 *  丑陋数是指只包含质因子 2, 3, 5 的正整数。
 *  我们将给定数字除以 2、3、5(顺序无所谓)，直到无法整除。
 *  如果得到 1，说明是所有因子都是 2 或 3 或 5，如果不是 1，则不是丑陋数。
 * 这就好像我们判断一个数字是否为 n(n 为大于 1 的正整数)的幂次方一样，
 * 我们只需要 不断除以 n，直到无法整除，如果得到 1，那么就是 n 的幂次方。
 * 这道题的不同在于 它不再是某一个数字的幂次方，而是三个数字（2，3，5），不过解题思路还是一样的。
 **/
public class IsUgly {
    public boolean isUgly(int num) {
        int[] ugly = {2, 3, 5};
        for (int i : ugly) {
            while (num %i == 0 && num%i < num) {
                num /= i;
            }
        }
        return num == 1;
    }
}
