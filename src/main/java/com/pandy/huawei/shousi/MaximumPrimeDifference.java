package com.pandy.huawei.shousi;

import java.util.ArrayList;
import java.util.List;

public class MaximumPrimeDifference {

    public int maximumPrimeDifference(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (zhishu(nums[i])) {
                list.add(i);
            }
        }
        list.sort((a1, a2) -> a2 - a1);
        return Math.abs(list.get(list.size() - 1) - list.get(0));
    }

    public boolean zhishu(int num) {
        if(num == 1) return false;
        boolean isprime = true;
        int len = num / 2;
        for (int i = 2; i <= len; i++) {
            if (num % i == 0) {
                isprime = false;
                break;
            }
        }
        return isprime;
    }

    public static void main(String[] args) {
        MaximumPrimeDifference m = new MaximumPrimeDifference();
//        m.maximumPrimeDifference(new int[]{4, 2, 9, 5, 3});
        m.maximumPrimeDifference(new int[]{1,7});
    }
}
