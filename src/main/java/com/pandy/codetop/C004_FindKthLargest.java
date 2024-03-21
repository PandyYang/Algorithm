package com.pandy.codetop;

import java.util.PriorityQueue;

/**
 * 使用的是最小堆（PriorityQueue在Java中默认是最小堆）。因此，peek()方法会返回当前堆中的最小元素。但在你的特定用例中，
 * 由于你维护的是一个大小为k的最小堆来找第k大的元素，堆中的元素实际上是数组中最大的k个元素。
 * 在这种情况下，peek()返回的是这k个元素中最小的那个，即第k大的元素。
 */
public class C004_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        return priorityQueue.peek();
    }
}
