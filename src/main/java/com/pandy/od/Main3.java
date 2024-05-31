package com.pandy.od;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.stream.Stream;

class Main3 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        System.out.println(t + "=" + t);

        List<String> res = new ArrayList<>();
        for (int n = 1; n < t; n++) {

            int sum = 0;
            StringBuilder builder = new StringBuilder();

            for (int i = n; sum < t; i++) {
                sum += i;
                if (sum == t) {
                    builder.append(i);
                    res.add(t + "=" + builder);
                    break;
                }
                builder.append(i).append("+");
            }
        }
        res.sort(Comparator.comparingInt(String::length));
        res.forEach(System.out::println);

        System.out.println("Result:" + (res.size() + 1));
    }

}
