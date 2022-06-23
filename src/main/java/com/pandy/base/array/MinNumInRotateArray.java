package com.pandy.base.array;

/**
 * @author Pandy
 * @date 24/12/2021
 *
 * 题意：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一 个旋转，输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
 * 该数组的最小值为1。 NOTE:给出的所有元素都大于0，若数组大小为0，请返回0
 *
 * 思路：
 * 利用二分法，找到中间的数，然后和最左边的值进行比较
 * 若大于最左边的数，则最左边从mid开始，若小于最右边的值，
 * 则最右边从mid开始，若左中右三值相等，取mid前后值中较小的数。
 * 1 2 3 4 5
 *
 * 2 3 4 5 1
 *
 * 3 4 5 1 2
 *
 * 4 5 1 2 3
 *
 *
 * 旋转之后的数组存在两个上升序列，最小元素在两个上升序列的中间
 * 用两个指针在两个序列中找到最大和最小的值，这样end指向的数则最小
 */
public class MinNumInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
       if (array.length == 0) return 0;
       int start = 0, end = array.length - 1;

       if (array[start] < array[end]) {
           return -1;
       }

       while (end - start != 1) {
           int mid = (start + end) / 2;

           if (array[mid] >= array[start]) {
               // 最小在右边
               start = mid;
           }

           if (array[mid] <= array[end]) {
               // 最小的在左边
               end = mid;
           }
       }
       return array[end];
    }

    public static void main(String[] args) {
        int i2 = minNumberInRotateArray(new int[]{2, 3, 4, 5, 1});
        System.out.println("i2 = " + i2);
        int i = minNumberInRotateArray(new int[]{1, 2, 3, 4, 5});
        System.out.println("i = " + i);
    }
}
