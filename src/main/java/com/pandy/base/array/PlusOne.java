package com.pandy.base.array;

/**
 * @author: Pandy
 * @create: 2022/3/27
 **/
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = plusOne(new int[]{1, 2, 9});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
