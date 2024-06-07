package com.pandy.hot100;

public class L38 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            answer[i] = product;
        }
        return answer;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = 1;
        }

        int prefixProduct = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffixProduct;
            suffixProduct *= nums[i];
        }

        return answer;
    }
}
