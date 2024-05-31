package com.pandy.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main6 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int[] arr1 = parseArray(in.nextLine());
        int[] arr2 = parseArray(in.nextLine());
        int k = in.nextInt();

        int initialCapacity = arr1.length * arr1.length;
        List<Integer> sums = new ArrayList<>(initialCapacity);
        for (int x : arr1) {
            for (int y : arr2) {
                sums.add(x + y);
            }
        }
        sums.sort(Integer::compareTo);
        int res = 0;
        for (int i = 0; i < k; i++) {
            res += sums.get(i);
        }
        System.out.println(res);
    }

    private static int[] parseArray(String line) {
        String[] split = line.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }


}
