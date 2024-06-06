package com.pandy.huawei;

public class Main {

    public static long lcmOfRange(int n) {
        long lcm = 1;
        for (int i = 1; i <= n; i++) {
            lcm = lcm(lcm, i);
        }
        return lcm;
    }

    // 求最大公倍数
    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    // 求最大公约数
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        long l = Main.lcmOfRange(3);
        System.out.println("l = " + l);
    }
}
