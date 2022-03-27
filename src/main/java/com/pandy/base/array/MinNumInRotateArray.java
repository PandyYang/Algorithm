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
 */
public class MinNumInRotateArray {
    public static int minNumberInRotateArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;

            //
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int i = minNumberInRotateArray(new int[]{2,3,4,5,1});
        System.out.println("i = " + i);
    }
}
