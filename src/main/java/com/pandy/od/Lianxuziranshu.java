package com.pandy.od;

import java.util.*;

public class Lianxuziranshu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        System.out.println(target + "=" + target);

        List<String> expression = new ArrayList<>();

        // 枚举从1开始的连续的自然数的个数
        for (int i = 1; i < target; i++) {
            int sum = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; sum < target; j++) {
                sum += j;
                sb.append(j).append("+");
                if (sum == target) {
                    expression.add(target + "=" + sb.substring(0, sb.length() - 1));
                    break;
                }
            }
        }

        Collections.sort(expression, Comparator.comparingInt(String::length));

        for (String s : expression) {
            System.out.println(s);
        }

        System.out.println("Result:" + (expression.size() + 1));
    }
}
