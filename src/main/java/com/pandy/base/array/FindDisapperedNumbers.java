package com.pandy.base.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/2/26
 * 找出数组中消失的数字
 *
 * 数字范围1 ---- n，而数组下标 0 ---- n-1 则可用数组原地标记数字是否出现过
 **/
public class FindDisapperedNumbers {

    public static List<Integer> find(int... nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
                System.out.println(nums[index]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index < len) {
            // 数字在对应的索引位置上
            if (nums[index] == index + 1) {
                index++;
            } else {
                int targetIndex = nums[index] - 1;
                if (nums[targetIndex] == nums[index]) {
                    index++;
                    continue;
                }
                int temp = nums[targetIndex];
                nums[targetIndex] = nums[index];
                nums[index] = temp;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] != i+1) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=====================");
        int[] arr = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> integers = find(arr);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
