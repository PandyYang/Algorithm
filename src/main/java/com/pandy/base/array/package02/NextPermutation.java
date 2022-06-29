package com.pandy.base.array.package02;

import java.util.Arrays;

/**
 * @author Pandy
 * @date 5/1/2022
 * 求下一个排列
 * <p>
 * 下一个数比当前数更大，这样才满足"下一个排列的定义" 因此只需要将后面的大数与前面的小数交换
 * 下一个数增加的幅度尽可能小
 * 1.在尽可能靠右的低位进行交换，需要从后向前查找
 * 2.将一个尽可能小的大数与前面的小数进行交换
 * 3.将大数换到前面后，将大数后面的所有数重置为升序
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        // 从后往前 （如果找不到 说明是最小序列 直接排序成最大的即可）
        for (int i = len - 1; i > 0; i--) {
            // 查找一个升序的
            if (nums[i] > nums[i - 1]) {

                // 大数之后的所有数重置为升序 升序排列就是最小的排列
                Arrays.sort(nums, i, len);

                // 之后将第一个比i大的数字 进行交换
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
