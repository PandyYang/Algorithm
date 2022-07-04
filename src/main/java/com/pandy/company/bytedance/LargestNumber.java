package com.pandy.company.bytedance;

import java.util.PriorityQueue;

/**
 * @author: Pandy
 * @create: 2022/7/3
 * <p>
 * 数组的数字重新排列后 组成的最大数
 **/
public class LargestNumber {

    public String largestNumber(int[] nums) {
        PriorityQueue<String> heap = new PriorityQueue<>(
                (x, y) -> (y + x).compareTo(x + y)
        );

        for (int num : nums) {
            heap.offer(String.valueOf(num));
        }

        String res = "";

        while (heap.size() > 0) res += heap.poll();

        if (res.charAt(0) == '0') return "0";

        return res;
    }
}
