package com.pandy.base.string;

/**
 * @author Pandy
 * @date 4/1/2022
 * 大数的相加
 */
public class AddString {
    public static String addString(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                carry += num1.charAt(i) - '0';
            }

            if (j >= 0) {
                carry += num2.charAt(j) - '0';
            }

            stringBuffer.append(carry % 10);
            carry = carry / 10;

            i--;
            j--;
        }

        if (carry > 0) {
            stringBuffer.append(carry);
        }

        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String s = addString("999", "999");
        System.out.println("s = " + s);
    }
}
