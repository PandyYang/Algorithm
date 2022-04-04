package com.pandy.base.math;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/3/29
 **/
public class NthUglyNum {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int res = 0;
        int index = 0;
        while (index < n) {
            res++;
            if (isUglyNum(res)) {
                index++;
            }
        }
        return res;
    }

    //方法：判断一个数是不是丑数
    public boolean isUglyNum(int num) {
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }

    public int nUglyNumber(int n) {
        int[] factors = {2,3,5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            Long curr = heap.poll();
            ugly = Math.toIntExact(curr);
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        NthUglyNum nthUglyNum = new NthUglyNum();
        int i = nthUglyNum.nthUglyNumber(1690);
        System.out.println(i);
    }

}
