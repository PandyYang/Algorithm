package com.pandy.base.array.package02;

/**
 * @author: Pandy
 * @create: 2022/2/26
 * 给定一个数组，将所有0移动到数组的末尾 同时保持非零元素的相对顺序
 *
 * 遍历数据 只要不为0 交换至index
 * 从index开始 全部复制为0
 **/
public class MoveZeros {

    public void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
