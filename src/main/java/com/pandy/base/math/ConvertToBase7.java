package com.pandy.base.math;

/**
 * @author: Pandy
 * @create: 2022/3/23
 * <p>
 * 7进制数
 **/
public class ConvertToBase7 {

    public String convertToBase7(int num) {

        StringBuilder sb = new StringBuilder();

        if (num == 0) return "0";

        boolean flag = num < 0;

        num = Math.abs(num);
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (flag) sb.append("-");
        return sb.reverse().toString();
    }
}
