package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/27
 * <p>
 * 二分查找
 * 求平方根
 **/
public class MySqrt {
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
