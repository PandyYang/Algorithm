package com.pandy.od;

import java.util.Scanner;
import java.util.Stack;

public class Main21 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] heights = new int[n];
        String[] input = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            heights[i] = Integer.parseInt(input[i]);
        }

        int[] friendIndex = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < n; i++) {

            // while一定能找到它的朋友，否则，将当前孩子入栈，证明没有朋友。
            while (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                // 当栈不为空，且当前孩子的身高大于栈顶孩子的身高时，将栈顶孩子的索引弹出，并在 friendIndex 中记录当前孩子的索引为栈顶孩子的好朋友。
                friendIndex[stack.pop()] = i;
            }
            // 当前孩子推入栈中
            stack.push(i);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(friendIndex[i]).append(" ");
        }

        System.out.println(result.toString().trim());
    }
}
