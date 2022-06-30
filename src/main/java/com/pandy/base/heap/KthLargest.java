package com.pandy.base.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: Pandy
 * @create: 2022/1/1
 * 数组中第K个最大的元素
 **/
public class KthLargest {
    public static int kth(int[] arr, int k) {

        // 使用优先队列进行解决
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.comparingInt(o -> o));

        for (int i : arr) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(i);
            } else if (priorityQueue.peek() < i) {
                priorityQueue.poll();
                priorityQueue.add(i);
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int kth = kth(arr, 2);
        System.out.println("kth = " + kth);
    }
}
