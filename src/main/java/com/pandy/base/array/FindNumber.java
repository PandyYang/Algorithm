package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/1/9
 *
 * 数组中有⼀个数字出现的次数超过数组⻓度的⼀半，请找出这个数字。例
 * 如输⼊⼀个⻓度为9的数组{1,2,3,2,2,2,5,4,2},由于数字2在数组中出现了5
 * 次，超过数组⻓度的⼀半，因此输出2
 *
 *
 * 解题思路
 * 摩尔投票法
 *
 * 因为数组中有一个数字出现的次数超过数组长度的一半
 * 如果我们把众数（出现次数超过一半的数字）记为 +1，把其他数记为 −1，将它们全部加起来，显然和大于 0，从结果本身我们可以看出众数比其他数多。
 **/
public class FindNumber {
    public static Integer findNum(int[] arr) {
        if (arr == null) return null;

        int result = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (count == 0) {
                result = arr[i];
                count = 1;
            } else if (arr[i] == result) {
                count++;
            }else {
                count--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer num = findNum(new int[]{1, 2, 3, 2, 2, 2, 2, 5, 4, 2});
        System.out.println("num = " + num);
    }
}
