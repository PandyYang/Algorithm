package com.pandy.company.pinduoduo;

import java.util.PriorityQueue;

/**
 * @author: Pandy
 * @create: 2022/7/7
 *
 * 求第k大的元素，默认使用小根堆，java优先队列默认是小根堆。
 * 求第k小的元素，默认使用大根堆，重写排序条件。
 **/
public class FindKthLargest {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else {
                if (priorityQueue.peek() < num) {
                    priorityQueue.remove();
                    priorityQueue.add(num);
                }
            }
        }
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int kthLargest = FindKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println("kthLargest = " + kthLargest);
    }
}
