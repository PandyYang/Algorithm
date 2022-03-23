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

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        int index = 0;
        while (index < len) {
            // 数字在对应的索引位置上
            if (nums[index] == index + 1) {
                index++;
            } else {
                int targetIndex = nums[index] - 1;
                // 数字在对应索引位置上（交换位置之后）1 5 3 4 5 6
                if (nums[targetIndex] == nums[index]) {
                    index++;
                    continue;
                }
                // 将数字交换至对应的索引上
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
        int[] nums = new int[]{1,3,4,5,5,6};
        List<Integer> integers2 = findDisappearedNumbers(nums);
        for (Integer res : integers2) {
            System.out.println("integer = " + res);
        }
    }
}
