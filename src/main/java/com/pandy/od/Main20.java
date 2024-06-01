package com.pandy.od;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prices = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = prices.length;

        int[] res = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int j = 0; j < n * 2 - 1; j++) {
            int index= j % n;
            while (!stack.isEmpty() && prices[stack.peek()] > prices[index]) {
                Integer topIndex = stack.pop();
                res[topIndex] = prices[topIndex] + prices[index];
            }

            if (j < n) {
                stack.push(index);
            }
        }

        while (!stack.isEmpty()) {
            int topIndex = stack.pop();
            res[topIndex] = prices[topIndex];
        }

        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());

    }
}
