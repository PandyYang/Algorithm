package com.pandy.od;

import java.util.Scanner;
import java.util.*;

public class Main8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count1 = in.nextInt();
        int count2 = in.nextInt();

        int[] nums1 = new int[count1];

        int sum1 = 0;
        for (int i = 0; i < count1; i++) {
            nums1[i] = in.nextInt();
            sum1 += nums1[i];
        }

        int sum2 = 0;
        int[] nums2 = new int[count2];

        for (int i = 0; i < count2; i++) {
            nums2[i] = in.nextInt();
            sum2 += nums2[i];
        }

        int ava = (sum1 + sum2) / 2;
        int value = Math.abs(ava - sum1);

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (sum1 > sum2) {
            for (int item : nums1) {
                if (contains(nums2, item - value)) {
                    System.out.println(item +" " + (item - value));
                    break;
                }
            }
        } else {
            for (int item : nums2) {
                if (contains(nums1, item - value)) {
                    System.out.println((item - value) + " " + item);
                    break;
                }
            }
        }
    }
        // 计算数组元素之和
        private static int sum(int[] arr) {
            int sum = 0;
            for (int num : arr) {
                sum += num;
            }
            return sum;
        }

        // 判断数组中是否包含某个值
        private static boolean contains(int[] arr, int target) {
            for (int num : arr) {
                if (num == target) {
                    return true;
                }
            }
            return false;
        }

}