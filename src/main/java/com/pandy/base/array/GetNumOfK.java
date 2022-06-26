package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/15
 * 
 * 
 * 统计一个数字在排序数组中出现得次数
 * 利用二分查找 找到任意一个k
 * 由于k有多个 并且当前找到得k可能在任意位置 所以在当前k得前后进行遍历查找
 **/
public class GetNumOfK {

    public static int getNumOfk(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        // 二分查找 先找出第一个k出现得位置
        int start = 0, end = arr.length - 1;
        int t = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == k) {
                // t 记录数组中元素出现得位置
                t = mid;
                break;
            } else if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (t == -1) {
            return 0;
        }

        //  找到第一个出现得位置之后 在其得左右两侧继续进行寻找
        int sum = 0;
        int a = t;

        // 左侧
        while (a >= 0 && arr[a] == k) {
            sum++;
            a--;
        }

        // 右侧
        a = t + 1;
        while (a < arr.length && arr[a] == k) {
            sum++;
            a++;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1, 1, 2, 2, 3, 4, 4, 4, 5, 6, 7, 8, 8, 8};
        int res = getNumOfk(arr, 8);
        System.out.println("res = " + res);
    }
}
