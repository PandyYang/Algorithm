package com.pandy.base.array.chapter01;

/**
 * @author: Pandy
 * @create: 2022/3/27
 *
 * 调整数组顺序 奇数位于偶数得前面
 **/
public class Exchange {

    public int[] exchange(int[] nums) {

        if (nums.length == 0) return nums;

        int i = 0;
        int j = nums.length - 1;

        while (i < j) {
            // 找偶数
            while (i < j && nums[i] % 2 != 0) {
                i++;
            }

            while (i < j && nums[j] % 2 == 0) {
                j--;
            }

            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
