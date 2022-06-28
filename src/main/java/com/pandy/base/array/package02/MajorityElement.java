package com.pandy.base.array.package02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/2/26
 *
 * 寻找众数
 *
 * 解法1： hashmap
 * 一个大小为n的数组，找到其中的多数元素，多数元素是指在数组中出现次数大于n/2的元素。
 * Map遍历所有元素出现次数 找出最大的即可
 *
 * 解法2：投票算法
 **/
public class MajorityElement {

    public static int majority2(int[] nums) {
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                majority = nums[i];
            }
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        int i = majority2(arr);
        System.out.println("i = " + i);
    }

    public int majority(int[] nums) {
        HashMap<Integer, Integer> keyVal = new HashMap<>();
        for (int num : nums) {
            if (keyVal.containsKey(num)) {
                keyVal.put(num, keyVal.get(num) + 1);
            } else {
                keyVal.put(num, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : keyVal.entrySet()) {
            if (entry.getKey() > max) {
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        return key;
    }
}
