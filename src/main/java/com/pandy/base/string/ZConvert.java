package com.pandy.base.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Pandy
 * @create: 2022/3/28
 **/
public class ZConvert {

    public static String convert(String s, int numRows) {
        if (numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;

        for (char c : s.toCharArray()) {
            rows.get(i).append(c);

            //  i为0或最后一个 分别加1 或者减去 1 z字形振动
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String paypalishiring = convert("PAYPALISHIRING", 3);
        System.out.println("paypalishiring = " + paypalishiring);
    }
}
