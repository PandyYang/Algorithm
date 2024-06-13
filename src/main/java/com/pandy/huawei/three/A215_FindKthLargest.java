package com.pandy.huawei.three;

import java.util.Arrays;
import java.util.PriorityQueue;

public class A215_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o1- o2);

        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(num);
            } else if (priorityQueue.peek() < num) {
                priorityQueue.poll();
                priorityQueue.add(num);
            }
        }
        return priorityQueue.poll();
    }

    public static void main(String[] args) {
        int kthLargest = new A215_FindKthLargest().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(kthLargest);
    }

    int find(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
