package com.pandy.huawei.three;

import java.util.Arrays;
import java.util.Stack;

public class A739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length - 1];
//        Arrays.fill(res, 0);
        P: for (int i = 0; i < temperatures.length; i++) {
            for (int j = i; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    continue P;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int idx = stack.pop();
                res[idx] = i - idx;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new A739_DailyTemperatures().dailyTemperatures2(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
