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
    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        int mid = 0;
        // 左大于右 数组已经旋转
        while (array[left] >= array[right]) {

            if(right - left <= 1) {
                mid = right;
                break;
            }
            mid = (left + right)/2;
            if (array[left] == array[mid] && array[mid] == array[right]) {
                // 出现相同的数字
                if (array[left + 1] != array[right - 1]) {
                    mid = array[left + 1] < array[right - 1] ? left + 1 : right - 1;
                } else {
                    left++;
                    right--;
                }
            } else {
                if (array[left] <= array[mid]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }

        return array[mid];
    }
}
