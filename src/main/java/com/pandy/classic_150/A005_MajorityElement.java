package com.pandy.classic_150;

// 摩尔投票法
public class A005_MajorityElement {
    public static int majorityElement(int[] nums) {
        int a = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {

            if (count == 0) {
                a = nums[i];
                count = 1;
            } else if (nums[i] == a) {
                count++;
            } else {
                count--;
            }

        }
        return a;
    }

    public static void main(String[] args) {
        int i = majorityElement(new int[]{1, 2, 2, 3, 3, 3, 0, 5});
        System.out.println("i = " + i);
    }
}
