package com.pandy.od;

import java.util.Scanner;

import java.util.Arrays;


public class Main9 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 指令的数量
        int n = in.nextInt();
        in.nextLine();

        int m = in.nextInt();
        in.nextLine();

        int[] ins = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int num = in.nextInt();
            ins[i] = num;
        }

        int[] point = new int[n + 1];
        point[0] = 0;
        for (int j = 1; j < n + 1; j++) {
            if (m == ins[j]) {
                if (m > 0) {
                    point[j] = point[j - 1] + ins[j] + 1;
                } else if (m == 0) {
                    point[j] = point[j - 1] + 1;
                } else {
                    point[j] = point[j - 1] + ins[j] - 1;
                }
            } else {
                point[j] = point[j - 1] + ins[j];
            }
        }
        Arrays.sort(point);
        System.out.println(point[n]);
    }
}