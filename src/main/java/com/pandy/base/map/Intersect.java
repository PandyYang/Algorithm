package com.pandy.base.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Pandy
 * @date 2/4/2022
 */
public class Intersect {
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                // 计算数组1中的元素总数 需要在元素二中进行对应 对应一次减去1 为0 的时候说明最小 此时不再加入
                map.replace(nums1[i], map.get(nums1[i]) + 1);
            } else {
                map.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                list.add(nums2[i]);
                map.replace(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (Integer integer : list) {
            res[i++] = integer;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
