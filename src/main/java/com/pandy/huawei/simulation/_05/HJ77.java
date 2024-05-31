package com.pandy.huawei.simulation._05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class HJ77 {

    private static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int trainCounts = sc.nextInt();
        int[] trains = new int[trainCounts];
        for (int i = 0; i < trainCounts; i++) {
            trains[i] = sc.nextInt();
        }

        findAllSequence(trains);

        // 对结果进行排序
        results.sort((o1, o2) -> {

            int n = o1.size();

            for (int i = 0; i < n; i++) {
                // 对比每一位的带下 从左到右
                if (!o1.get(i).equals(o2.get(i))) {
                    return o1.get(i) - o2.get(i);
                }
            }
            return 0;
        });
        // 打印排序后的结果
        for (List<Integer> result : results) {
            for (int num : result) {
                System.out.print(num + " ");
            }
            System.out.println();
        }


    }
    static void findAllSequence(int[] trains) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> path = new ArrayList<>();
        recurse(trains, 0, stack, path);
    }

    private static void recurse(int[] trains, int index, Stack<Integer> stack, List<Integer> path) {
        if (index == trains.length && stack.isEmpty()) {
            results.add(new ArrayList<>(path));
            return;
        }

        // 火车出站
        // 如果栈不为空，将栈顶元素出栈，添加到路径中，继续递归，然后恢复状态。
        if (!stack.isEmpty()) {
            Integer top = stack.pop();
            path.add(top);
            recurse(trains, index, stack, path);
            path.remove(path.size() - 1);
            stack.push(top);
        }

        // 火车进站
        // 如果还有火车未入站，将下一辆火车入栈，递归，然后恢复状态。
        if (index < trains.length) {
            stack.push(trains[index]);
            recurse(trains, index + 1, stack, path);
            stack.pop();
        }
    }
}
