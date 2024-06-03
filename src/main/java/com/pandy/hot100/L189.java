package com.pandy.hot100;

public class L189 {
    public static void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }

        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int index = i + k;

            if (index > nums.length - 1) {
                index = index % nums.length;

            }
            res[index] = nums[i];
        }
        System.arraycopy(res, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
       L189.rotate(new int[]{1, 2}, 1);

    }
}
