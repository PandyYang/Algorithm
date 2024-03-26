package com.pandy.codetop;

public class C037_MySqrt {

    public int mySqrt(int x) {
        if (x == 0) return x;
        int left = 1, right = x;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid <= x / mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }
}
