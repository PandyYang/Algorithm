package com.pandy.base.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/2/26
 * 找出数组中消失的数字
 *
 * 数字范围1 - n，而数组下标 0 - n-1 则可用数组原地标记数字是否出现过
 **/
public class FindDisapperedNumbers {

    public static List<Integer> find(int... nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }
}
