package com.pandy.od;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.stream.Stream;

class Main7 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        Set<Integer> factors = new HashSet<>();

        int tmp = num;
        int f = 2;
        while (tmp != 1) {
            if (tmp % f != 0) {
                f++;
            } else {
                factors.add(f);
                tmp /= f;
            }
        }

        boolean flag = true;
        for (Integer f1 : factors) {
            for (Integer f2 : factors) {
                if (f1 * f2 == num) {
                    int min = Math.min(f1, f2);
                    int max = Math.max(f1, f2);
                    System.out.print(min + " " + max);
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (flag) {
            System.out.print("-1 -1");
        }

    }

}
