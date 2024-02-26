package com.pandy.codetop;

public class QuickSort {

    // ����������ں���
    public void quickSort(int[] array) {
        if (array == null || array.length == 0) {
            return; // �������Ϊ�ջ��߳���Ϊ0������Ҫ����ֱ�ӷ���
        }
        int length = array.length;
        quickSortHelper(array, 0, length - 1); // ���ø����������п�������
    }

    // ��������ĸ�������
    private void quickSortHelper(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high); // ��ȡ��׼Ԫ�ص�����λ��
            // �ݹ�ضԻ�׼Ԫ���������ߵ���������п�������
            quickSortHelper(array, low, pivotIndex - 1);
            quickSortHelper(array, pivotIndex + 1, high);
        }
    }

    // ��������������ȷ����׼Ԫ�ص�λ��
    private int partition(int[] array, int low, int high) {
        int pivot = array[high]; // ѡ�����һ��Ԫ����Ϊ��׼Ԫ��
        int i = low - 1; // ��ʼ�� i ָ�룬ָ���λ��ǰһ��λ��
        for (int j = low; j < high; j++) {
            // �����ǰԪ��С�ڵ��ڻ�׼Ԫ�أ���������λ����
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j); // ����Ԫ�أ���С�ڵ��ڻ�׼Ԫ�ص�Ԫ�ط����λ����
            }
        }
        swap(array, i + 1, high); // ����׼Ԫ�ط�����ȷ��λ��
        return i + 1; // ���ػ�׼Ԫ�ص�����λ��
    }

    // ��������������Ԫ�ص�λ��
    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // ���Կ��������㷨
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
