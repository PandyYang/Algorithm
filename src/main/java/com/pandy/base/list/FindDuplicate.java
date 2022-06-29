package com.pandy.base.list;

/**
 * @author: Pandy
 * @create: 2022/6/29
 **/
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int duplicate = findDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2});
        System.out.println("duplicate = " + duplicate);
    }

    public int findDuplicate(int[] nums) {
        /**
         * 快慢指针思想, fast 和 slow 是指针, nums[slow] 表示取指针对应的元素
         *         注意 nums 数组中的数字都是在 1 到 n 之间的(在数组中进行游走不会越界),
         *         因为有重复数字的出现, 所以这个游走必然是成环的, 环的入口就是重复的元素,
         *         即按照寻找链表环入口的思路来做
         */

        int fast = 0, slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];

            // 环的入口
            if (slow == fast) {
                fast = 0;
                while (nums[slow] != nums[fast]) {
                    fast = nums[fast];
                    slow = nums[slow];
                }
                return nums[slow];
            }
        }
    }
}
