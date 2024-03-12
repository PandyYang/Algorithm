package com.pandy.base.array.package3;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * 创建一个新的数组 newnums，其内容是原始数组 nums 的副本，并对 newnums 进行排序。
 * 使用两个指针 i 和 j 分别指向数组的起始位置和末尾位置。
 * 向右移动指针 i 直到找到第一个不等于排序后数组中对应位置的元素为止。这表示找到了需要排序的子数组的起始位置。
 * 向左移动指针 j 直到找到最后一个不等于排序后数组中对应位置的元素为止。这表示找到了需要排序的子数组的结束位置。
 * 返回子数组的长度，即 j - i + 1。
 * 该方法的时间复杂度为 O(nlogn)，其中 n 是数组的长度，主要由排序操作决定。
 **/
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] newnums = nums.clone();
        Arrays.sort(newnums);

        int i = 0, j = n - 1;

        while (i < n && nums[i] == newnums[i]) ++i;
        while (j > i && nums[j] == newnums[j]) --j;

        return j - i + 1;
    }
}
