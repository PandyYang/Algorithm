package com.pandy.company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/7/2
 *
 * z 字型变换
 *
 * flag的变化: 1 1 -1 -1 循环
 * i的变化: 0 1 2 1。。。。。。  0 1 2 1循环，也就是0 - 2之间跳动
 *
 **/
public class Convert {

    public String convert(String s, int numRows) {
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        /**
         * flag的变化: 1 1 -1 -1 循环
         * i的变化: 0 1 2 1。。。。。。  0 1 2 1循环，也就是0 - 2之间跳动
         */
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);

            if (i == 0 || i == numRows - 1) flag = -flag;

            i += flag;

            // System.out.println("flag: " + flag + " i: " + i);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (StringBuilder row : rows) {
            stringBuilder.append(row);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Convert convert = new Convert();
        String paypalishiring = convert.convert("PAYPALISHIRING", 3);
        System.out.println("paypalishiring = " + paypalishiring);
    }
}
