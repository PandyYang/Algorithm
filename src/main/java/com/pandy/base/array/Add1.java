package com.pandy.base.array;

/**
 * @author Pandy
 * @date 23/3/2022
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Add1 {

    public static int[] add1(int[] arr) {
        int n = arr.length;
        for (int i = arr.length - 1; i >= 0; i--) {

            // 遍历数组的每一位，小于9，则+1直接返回
            // 注意 只要不全为9 此处绝对会跳出
            if (arr[i] < 9) {
                arr[i]++;
                return arr;
            }

            // 大于9 将该位置为0
            arr[i] = 0;
        }

        // 每位都是9
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9,1,9};
        int[] ints = add1(arr);
        for (int anInt : ints) {
            System.out.println("anInt = " + anInt);
        }
    }

}
