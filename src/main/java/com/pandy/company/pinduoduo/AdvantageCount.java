package com.pandy.company.pinduoduo;

import java.util.TreeMap;

/**
 * @author: Pandy
 * @create: 2022/7/7
 *
 * 优势洗牌
 *
 * 给定两个大小相等的数组nums1和nums2，nums1相对于 nums的优势可以用满足nums1[i] > nums2[i]的索引 i的数目来描述。
 *
 * 返回 nums1的任意排列，使其相对于 nums2的优势最大化。
 **/
public class AdvantageCount {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++){
            int num = nums2[i];
            Integer higher = map.higherKey(num);

            if (higher == null){
                ans[i] = map.firstKey();
            }

            else{
                ans[i] = higher;
            }

            // 已经使用了一个数量 所以减去1
            map.put(ans[i], map.get(ans[i]) - 1);

            // 元素用完了 移除
            if (map.get(ans[i]) == 0){
                map.remove(ans[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        AdvantageCount advantageCount = new AdvantageCount();
        int[] ints = advantageCount.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
