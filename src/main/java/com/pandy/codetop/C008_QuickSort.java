package com.pandy.codetop;

public class C008_QuickSort {

    public int[] quickSort(int[] nums) {
       if (nums.length < 1) return nums;
       qSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void qSort(int[] nums, int start, int end) {
        int l = start, r = end;

        if (l < r) {
            // 选择基准元素
            int temp = nums[l];

            while (l < r) {
                // 小的放左边
                while (l < r && nums[r] >= temp) r --;
                if (l < r) nums[l] = nums[r];

                // 大的放右边
                while (l < r && nums[l] < temp) l++;
                if (l < r) nums[r] = nums[l];
            }

            nums[l] = temp;
            qSort(nums, start, l);
            qSort(nums, l + 1, end);
        }
    }


    public static void main(String[] args) {
        C008_QuickSort sorter = new C008_QuickSort();
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        int[] ints = sorter.quickSort(arr);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
