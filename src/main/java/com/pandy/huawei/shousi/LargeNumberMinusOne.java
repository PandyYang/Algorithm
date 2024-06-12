package com.pandy.huawei.shousi;

public class LargeNumberMinusOne {

    public static String minusOne(String number) {
        if (number == null || number.length() == 0) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        StringBuilder result = new StringBuilder();
        int carry = -1; // 用于减一操作
        int length = number.length();

        for (int i = length - 1; i >= 0; i--) {
            int digit = number.charAt(i) - '0';
            digit += carry;
            if (digit < 0) {
                digit += 10;
                carry = -1; // 借位
            } else {
                carry = 0; // 无需继续借位
            }
            result.append(digit);
        }

        // 移除前导零
        while (result.length() > 1 && result.charAt(result.length() - 1) == '0') {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(minusOne("1000")); // 输出: "999"
        System.out.println(minusOne("1"));    // 输出: "0"
        System.out.println(minusOne("12345678901234567890")); // 输出: "12345678901234567889"
    }
}
