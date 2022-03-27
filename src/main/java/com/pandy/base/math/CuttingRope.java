package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/27
 **/
public class CuttingRope {
    public int cutting(int n) {
        if(n == 1 || n == 2) return 1;
        if (n == 3) return 2;
        int sum = 1;
        while (n > 4) {
            sum *= 3;
            n -= 3;
        }
        return sum *n;
    }
}
