package com.pandy.base.sort;

/**
 * @Author Pandy
 * @Date 2021/7/23 0:10
 * 算法思想：通过一趟排序将待排记录分隔成独立的两部分，
 * 其中一部分比关键字小，后面一部分比关键字大，然后再对这前后的
 * 两部分分别采用这种方式进行排序，通过递归的运算最终达到整个序列有序。
 *
 */
public class FastSort {
   private static void quickSort(int[] arr, int left, int right) {
       if (left > right) {
           return;
       }

       // base中存放基准数
       int base = arr[left];
       int i = left, j = right;
       while (i != j) {
           // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
           while (arr[j] >= base && i < j) {
               j--;
           }

           // 再从左往右找，直到找到比base值大的数
           while (arr[i] <= base && i < j) {
               i++;
           }

           if (i < j) {
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }

       // 将基准数放到中间的位置
       arr[left] = arr[i];
       arr[i] = base;

       quickSort(arr, left, i - 1);
       quickSort(arr, i + 1, right);
   }
}
