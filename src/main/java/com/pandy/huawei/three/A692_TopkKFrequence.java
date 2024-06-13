package com.pandy.huawei.three;

import com.pandy.base.tree.traversal.In;

import java.util.*;

public class A692_TopkKFrequence {
    public List<String> topKFrequent(String[] words, int k) {
        // 入map
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>((a,b)
                ->a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : a.getValue() - b.getValue()
        );

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll().getKey());
        }

        Collections.reverse(result);
        return result;
    }
}
