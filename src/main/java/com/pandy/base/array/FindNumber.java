package com.pandy.base.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Pandy
 * @create: 2022/1/9

 * 数组中有⼀个数字出现的次数超过数组⻓度的⼀半，请找出这个数字。例
 * 如输⼊⼀个⻓度为9的数组{1,2,3,2,2,2,5,4,2},由于数字2在数组中出现了5
 * 次，超过数组⻓度的⼀半，因此输出2
 * 解题思路
 * 摩尔投票法
 * 因为数组中有一个数字出现的次数超过数组长度的一半
 * 如果我们把众数（出现次数超过一半的数字）记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
 * 解法2：
 * 使用map存储元素与出现的次数，遍历map，寻找出现次数最大的
 **/
public class FindNumber {
    public static Integer findNum(int[] arr) {
        if (arr == null) return null;

        int result = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                result = arr[i];
                count = 1;
            } else if (arr[i] == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }
        return counts;
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }
}
