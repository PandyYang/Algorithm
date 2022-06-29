package com.pandy.base.array;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/29
 *
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 **/
public class FindUnsortedSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] newnums = nums.clone();
        Arrays.sort(newnums);

        int i=0,j= n-1;

        while(i < n && nums[i] == newnums[i]) ++i;
        while(j > i && nums[j] == newnums[j]) --j;

        return j-i+1;
    }
}
