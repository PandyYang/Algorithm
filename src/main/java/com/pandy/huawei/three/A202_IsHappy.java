package com.pandy.huawei.three;

import java.util.HashSet;
import java.util.Set;

public class A202_IsHappy {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        while (num > 0) {
            int dig = num % 10;
            sum += dig * dig;
            num /= 10;
        }
        return sum;
    }
}
