package com.pandy.huawei.simulation._01;

import java.util.Scanner;

public class HJ91 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println(cal(m, n));
        }
    }

    private static int cal(int m, int n) {
        if (m == 1 || n == 1) {
            return m + n;
        }

        return cal(m - 1, n) + cal(m, n -1);
    }
}
