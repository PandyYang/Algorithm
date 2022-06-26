package com.pandy.base.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * 
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 * 
 * 用一个 hashmap 存储已经访问过的数字，每次访问都查看 hashmap 中是否有这个元素，
 * 有的话拿出索引进行比对，是否满足条件（相隔不大于 k），如果满足返回 true 即可。
 **/
public class ContainsNearbyDuplicate {

    // 哈希表
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.get(nums[i]) != null && (i - map.get(nums[i]) <= k)) {
                return true;
            }
            // 哈希表中的每个数组值只需要存一个最近的坐标
            map.put(nums[i], i);
        }
        return false;
    }

    // 滑动窗口
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            // 数组向右滑动
            if (i > k) set.remove(nums[i - k - 1]);
            // 有重复元素
            if (!set.add(nums[i])) return true;
        }
        return false;
    }
}
