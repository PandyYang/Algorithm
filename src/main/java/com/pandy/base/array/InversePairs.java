package com.pandy.base.array;

/**
 * @author Pandy
 * @date 6/7/2022
 * <p>
 * 数组中的逆序对
 */
public class InversePairs {
    public int count = 0;

    public static void main(String[] args) {
        InversePairs inversePairs = new InversePairs();
        int i = inversePairs.inversePairs(new int[]{1, 2, 3, 4, 5, 6, 7, 0});
        System.out.println("i = " + i);
    }

    public int inversePairs(int[] array) {
        if (array.length < 2) return 0;
        mergeSort(array, 0, array.length - 1);
        return count;
    }

    public void mergeSort(int[] array, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left < right) {
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    public void merge(int[] array, int left, int mid, int right) {
        // 创建临时数组 长度为此时两个子数组加起来的长度
        int[] arr = new int[right - left + 1];
        // 临时数组的下标起点
        int c = 0;
        // 保存在原数组的起点下标值
        int s = left;
        // 左子数组的起始指针
        int l = left;
        // 右子数组的起始指针
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (array[l] <= array[r]) {
                arr[c] = array[l];
                c++;
                l++;
            } else {
                arr[c] = array[r];
                count += mid + 1 - l;
                count %= 1000000007;
                c++;
                r++;
            }
        }

        while (l <= mid) {
            arr[c++] = array[l++];
        }

        while (r <= right) {
            arr[c++] = array[r++];
        }

        for (int num : arr) {
            array[s++] = num;
        }
    }
}
