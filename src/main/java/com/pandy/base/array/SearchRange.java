package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/3/26
 * <p>
 * 数字的范围 找出第一个和最后一个数字
 **/
public class SearchRange {

    public static int[] searchRange(int[] nums, int target) {

        int[] res = new int[]{-1, -1};
        if (nums.length < 1) return res;
        boolean flag = false;

        if (nums.length == 1 && target != nums[0]) {
            return res;
        }

        if (nums.length == 1) return new int[]{0, 0};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res[0] = i;
                flag = true;
            }

            if (i == nums.length - 1) {
                flag = false;
            }

            if (flag) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target) {
                        res[1] = j;
                        if (j == nums.length - 1) {
                            return res;
                        }
                    } else {
                        if (res[1] > res[0]) return res;
                        flag = false;
                    }
                }
            }
        }
        if (!flag) {
            res[1] = res[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int[] ints = searchRange(arr, 8);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }
}
