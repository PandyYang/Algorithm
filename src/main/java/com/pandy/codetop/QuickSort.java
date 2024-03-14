package com.pandy.codetop;

public class QuickSort {

    // 快速排序入口函数
    public void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return; // 如果数组为空或者长度为0，则不需要排序，直接返回
        }
        int length = array.length;
        quickSortHelper(array, 0, length - 1); // 调用辅助函数进行快速排序
    }

    // 快速排序的辅助函数
    private void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high); // 获取基准元素的索引位置
            // 递归地对基准元素左右两边的子数组进行快速排序
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }

    // 分区函数，用于确定基准元素的位置
    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // 选择最后一个元素作为基准元素
        int i = low - 1; // 初始化 i 指针，指向低位的前一个位置
        for (int j = low; j < high; j++) {
            // 如果当前元素小于等于基准元素，则将其放入低位区域
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j); // 交换元素，将小于等于基准元素的元素放入低位区域
            }
        }
        swap(array, i + 1, high); // 将基准元素放入正确的位置
        return i + 1; // 返回基准元素的最终位置
    }

    // 交换数组中两个元素的位置
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // 测试快速排序算法
    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        sorter.quickSort(arr);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
