package com.pandy.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                list.add(num2);
            }
        }
        int len = list.size();
        int[] arr = new int[len];
        for (int l : list) {
            len--;
            arr[len] = l;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] intersect = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i : intersect) {
            System.out.println("i = " + i);
        }
    }
}
