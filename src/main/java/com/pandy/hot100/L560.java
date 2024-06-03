package com.pandy.hot100;

public class L560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                if (sum(nums, i, j) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int sum(int[] nums, int i, int j) {
        int sum = 0;
        for (int k = i; k < j; k++) {
            sum += nums[k];
        }
        return sum;
    }


    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        L560 l560 = new L560();
//        int i = l560.subarraySum(new int[]{1, 1, 1}, 2);
//        int i = l560.subarraySum(new int[]{1, 2, 3}, 3);
        int i = l560.subarraySum(new int[]{1, -1, 0}, 0);
        System.out.println("i = " + i);
    }
}
