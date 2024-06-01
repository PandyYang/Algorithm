package com.pandy.hot100;


/***
 * 移动零
 */
public class L283 {
    // 遇见0就冒泡排序
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0; // 用于记录最后一个非0元素应放的位置
        // 通过一次遍历完成所有非0元素的正确定位
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // 从上一步结束的位置开始，将数组其余部分填充为0
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
