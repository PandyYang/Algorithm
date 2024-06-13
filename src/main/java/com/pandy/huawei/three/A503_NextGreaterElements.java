package com.pandy.huawei.three;

import java.util.Arrays;
import java.util.Stack;

/**
 * stack用于存储数组的下标
 * 循环两次 需要将前面的元素进行处理
 * 栈用于存储小于当前元素的元素的下标
 * 如果遇见大的
 * 弹栈到res中
 * res初始化为-1
 */
public class A503_NextGreaterElements {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < 2 * n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = new A503_NextGreaterElements().nextGreaterElements(new int[]{1, 2, 1});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
