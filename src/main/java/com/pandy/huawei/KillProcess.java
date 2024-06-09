package com.pandy.huawei;

import java.util.*;

public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        // 构建进程树
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                // pid.get(i)是获取父进程
                tree.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
            }
        }

        // 使用 BFS 进行遍历，找到所有需要杀死的进程
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(kill);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            if (tree.containsKey(current)) {
                queue.addAll(tree.get(current));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KillProcess solution = new KillProcess();
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        int kill = 5;
        System.out.println(solution.killProcess(pid, ppid, kill)); // 输出: [5, 10]
    }
}
