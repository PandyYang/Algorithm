package com.pandy.company.pinduoduo.sort;

/**
 * @author: Pandy
 * @create: 2022/7/7
 *
 * 快速排序
 **/
public class FastSort {

    public int[] quickSort(int[] nums) {
        if (nums.length < 1) return nums;
        qSort(nums, 0, nums.length -1);
        return nums;
    }

    private void qSort(int[] nums, int start, int end) {
        int l = start, r = end;
        if (l < r) {
            int temp = nums[l];
            while (l < r) {
                // 找出比中心轴小的 放在中心轴位置 左边
                while (l < r && nums[r] >= temp) r--;
                if (l < r) nums[l] = nums[r];
                // 找出比中心轴大的
                while (l < r && nums[l] < temp) l++;
                // 将其放在中心轴右边
                if (l < r) nums[r] = nums[l];
            }

            nums[l] = temp;
            qSort(nums, start, l);
            qSort(nums, l + 1, end);
        }
    }

    public static void main(String[] args) {
        FastSort fastSort = new FastSort();
        int[] ints = fastSort.quickSort(new int[]{5, 4, 3, 1, 2});
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
