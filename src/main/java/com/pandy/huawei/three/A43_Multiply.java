package com.pandy.huawei.three;

/**
 * 字符串相乘
 */
public class A43_Multiply {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m+n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 乘积的高位
                int high = i + j;
                // 乘积的低位
                int low = i + j + 1;

                int sum = mul + res[low];

                res[high] += sum / 10;
                res[low] = sum % 10;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int re : res) {
            if (!(stringBuilder.length() == 0 && re == 0)) {
                stringBuilder.append(re);
            }
        }
        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public static void main(String[] args) {
        String multiply = new A43_Multiply().multiply("123", "456");
        System.out.println("multiply = " + multiply);
    }
}
