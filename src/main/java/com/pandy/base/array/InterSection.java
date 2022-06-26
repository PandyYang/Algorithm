package com.pandy.base.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * <p>
 * 计算两个数组的交集
 **/
public class InterSection {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        return Arrays.stream(nums2).distinct().filter(set::contains).toArray();
    }
}
