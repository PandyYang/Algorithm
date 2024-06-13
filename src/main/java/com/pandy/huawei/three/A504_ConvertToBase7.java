package com.pandy.huawei.three;

public class A504_ConvertToBase7 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean flag = num < 0;
        num = Math.abs(num);

        StringBuilder stringBuilder = new StringBuilder();
        while (num > 0) {
            stringBuilder.append(num % 7);
            num /= 7;
        }

        if (flag) {
            stringBuilder.append("-");
        }

        return stringBuilder.reverse().toString();
    }
}
