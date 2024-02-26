package com.pandy.base.math;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            // 将得到的字符转换为对应的整数值。在 ASCII 和 Unicode 编码中，数字字符 '0' 到 '9' 是连续排列的，且 '0' 的编码值是 48。所以，当你从字符 '0' 中减去 '0' 时，你得到的是整数 0；从字符 '1' 中减去 '0'，你得到的是整数 1，以此类推。这是一个从字符表示的数字转换为实际整数值的快捷方法。
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? a.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2? sum - 2 : sum;
            sb.append(sum);
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    public String addStrings(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum / 10;  // 在十进制中，进位是总和除以10的结果
            sum = sum % 10;    // 当前位的数字是总和除以10的余数
            sb.append(sum);
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }


}
