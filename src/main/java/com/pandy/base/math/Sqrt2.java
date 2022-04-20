package com.pandy.base.math;

/**
 * @author Pandy
 * @date 19/4/2022
 *
 * sqrt(2)约等于1.414 不用数学库 求小数点后10位
 */
public class Sqrt2 {

    public static final double EPSILON = 0.0000000001;

    public double sqrt2() {
        double low = 1.4, high = 1.5;

        double mid = (low + high) / 2;

        while (high - low > EPSILON) {
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (high + low) / 2;
        }
        return mid;
    }
}
