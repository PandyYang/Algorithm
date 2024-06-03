package com.pandy.hot100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class L239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i <nums.length - k + 1; i++) {
            int num = findMax(nums, i, i+k);
            res.add(num);
        }
        int[] intArray = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            intArray[i] = res.get(i);
        }
        return intArray;
    }

    public int findMax(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        for (int i1 = i; i1 < j; i1++) {
            max = Math.max(max, nums[i1]);
        }
        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements not in the sliding window
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements smaller than the current element from the end
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add current element at the end of the deque
            deque.offerLast(i);

            // The first element of the deque is the largest element in the current window
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {

        int[] res = new int[nums.length-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i=0; i<k; i++) {
            inQueue(deque, nums[i]);
        }

        for (int i=0; i<nums.length-k+1; i++) {
            res[i] = deque.getFirst();
            if (i+k < nums.length) {
                if (deque.getFirst() == nums[i]) {
                    deque.removeFirst();
                }
                inQueue(deque, nums[i+k]);
            }
        }
        return res;
    }

    // 总是将较大的那一个元素入队
    private void inQueue(ArrayDeque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.getLast() < num) {
            deque.removeLast();
        }
        deque.addLast(num);
    }

    public static void main(String[] args) {
        L239 l239 = new L239();
        int[] ints = l239.maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
