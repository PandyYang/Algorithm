package com.pandy.test;

/**
 * 使用双指针移除元素
 * next指针来记录不重复的长度
 * cur指针用来表示当前元素
 */
public class A002_RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int next = 0;
        for (int cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != val) {
                nums[next] = nums[cur];
                next++;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int i = removeElement(new int[]{2}, 3);
        System.out.println("i = " + i);
    }
}
