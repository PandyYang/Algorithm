package com.pandy.base.priority;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Pandy
 * @date 29/3/2022
 * 
 * 获取最小的k个数 优先队列 自定义大小比较
 */
public class GetLeastNumbers {

    public static int[] getLeastNumbers(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int i : arr) {
            if (minQueue.size() < k) {
                minQueue.add(i);
            } else {
                if (!minQueue.isEmpty() && minQueue.peek() > i) {
                    minQueue.poll();
                    minQueue.add(i);
                }
            }
        }
        int[] arr2 = new int[minQueue.size()];
        int i = 0;
        while (!minQueue.isEmpty()) {
            arr2[i] = minQueue.poll();
            i++;
        }
        return arr2;
    }

    public static void main(String[] args) {
        int[] leastNumbers = getLeastNumbers(new int[]{5, 4, 3, 2, 1}, 2);
        for (int leastNumber : leastNumbers) {
            System.out.println("leastNumber = " + leastNumber);
        }
    }
}
