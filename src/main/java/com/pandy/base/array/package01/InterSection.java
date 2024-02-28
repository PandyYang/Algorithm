package com.pandy.base.array.package01;

import java.util.Arrays;
import java.util.HashSet;
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

    /**
     * 使用scala
     * val filterTopicPatterns = topicPatterns.filter(tp => {
     *      topicConfig.c_pattern_ids.exists(_.split(",").contains(tp.c_id.get.toString))
     *     })
     */

    public static void main(String[] args) {
        Integer[] arr1 = {1, 2, 3, 4, 5};
        Integer[] arr2 = {4, 5, 6, 7, 8};

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(arr1));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(arr2));

        set1.retainAll(set2);

        Integer[] intersection = set1.toArray(new Integer[0]);
        System.out.println("Arrays.toString(intersection) = " + Arrays.toString(intersection));

    }
}
